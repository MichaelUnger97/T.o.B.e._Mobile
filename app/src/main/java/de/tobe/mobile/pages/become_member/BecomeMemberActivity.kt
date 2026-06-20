package de.tobe.mobile.pages.become_member

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import de.tobe.mobile.R
import de.tobe.mobile.databinding.ActivityAboutUsBinding
import de.tobe.mobile.pages.BaseActivity

class BecomeMemberActivity : BaseActivity() {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)

        binding.toolbar
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment_content_main, ThirtiethFragment())
            setReorderingAllowed(true)
            addToBackStack(null) // Name can be null
        }
        binding.buttonFirst.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, ThirtiethFragment())
                setReorderingAllowed(true)
                addToBackStack(null) // Name can be null
            }
        }
        binding.buttonNext.setOnClickListener {
            val fragmentNr = findFragmentNr()
            getNext(fragmentNr).let { fragment ->
                supportFragmentManager.commit {
                    replace(R.id.nav_host_fragment_content_main, fragment)
                    setReorderingAllowed(true)
                    addToBackStack(null) // Name can be null
                }
            }
        }
        binding.buttonPrevious.setOnClickListener {
            val fragmentNr = findFragmentNr()
            getPrev(fragmentNr).let { fragment ->
                supportFragmentManager.commit {
                    replace(R.id.nav_host_fragment_content_main, fragment)
                    setReorderingAllowed(true)
                    addToBackStack(null) // Name can be null
                }
            }
        }
    }

    private fun findFragmentNr(): Int? {
        supportFragmentManager.executePendingTransactions()
        val fragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)!!
        val fragmentNr = when (fragment) {
            is ThirtiethFragment -> 0
            is ThirtyfirstFragment -> 1
            is ThirtysecondFragment -> 2
            is ThirtythirdFragment -> 3
            else -> null
        }
        return fragmentNr
    }

    private fun getNext(current: Int?): Fragment {
        return current?.let {
            val next = it + 1
            if (next < 4) {
                fragmentFromNr(next)
            } else {
                ThirtythirdFragment()
            }
        } ?: ThirtythirdFragment()
    }

    private fun getPrev(current: Int?): Fragment {
        return current?.let {
            val prev = it - 1
            fragmentFromNr(prev)
        } ?: ThirtiethFragment()
    }

    private fun fragmentFromNr(nr: Int): Fragment? {
        return when (nr) {
            0 -> ThirtiethFragment()
            1 -> ThirtyfirstFragment()
            2 -> ThirtysecondFragment()
            3 -> ThirtythirdFragment()
            else -> null
        }
    }
}