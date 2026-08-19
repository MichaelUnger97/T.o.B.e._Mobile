package de.tobe.mobile.pages.satzung

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import de.tobe.mobile.R
import de.tobe.mobile.databinding.ActivityHomeBinding
import de.tobe.mobile.pages.BaseActivity

class SatzungActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)

        binding.toolbar
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment_content_main, FortyfirstFragment())
            setReorderingAllowed(true)
            addToBackStack(null) // Name can be null
        }
        binding.buttonFirst.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, FortyfirstFragment())
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
            is FortyfirstFragment -> 1
            is FortysecondFragment -> 2
            is FortythirdFragment -> 3
            is FortyfourthFragment -> 4
            is FortyfifthFragment -> 5
            is FortysixthFragment -> 6
            is FortyseventhFragment -> 7
            is FortyEightFragment -> 8
            is FortyninthFragment -> 9
            is FiftiethFragment -> 10
            is FiftyfirstFragment -> 11
            is FiftysecondFragment -> 12
            is FiftythirdFragment -> 13
            else -> null
        }
        return fragmentNr
    }

    private fun getNext(current: Int?): Fragment {
        return current?.let {
            val next = it + 1
            if (next < 14) {
                fragmentFromNr(next)
            } else {
                FiftythirdFragment()
            }
        } ?: FortyfirstFragment()
    }

    private fun getPrev(current: Int?): Fragment {
        return current?.let {
            val prev = it - 1
            fragmentFromNr(prev)
        } ?: FortyfirstFragment()
    }

    private fun fragmentFromNr(nr: Int): Fragment? {
        return when (nr) {
            1 -> FortyfirstFragment()
            2 -> FortysecondFragment()
            3 -> FortythirdFragment()
            4 -> FortyfourthFragment()
            5 -> FortyfifthFragment()
            6 -> FortysixthFragment()
            7 -> FortyseventhFragment()
            8 -> FortyEightFragment()
            9 -> FortyninthFragment()
            10 -> FiftiethFragment()
            11 -> FiftyfirstFragment()
            12 -> FiftysecondFragment()
            13 -> FiftythirdFragment()
            else -> null
        }
    }
}