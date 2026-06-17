package de.tobe.mobile.page_about_us

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import de.tobe.mobile.R
import de.tobe.mobile.databinding.ActivityAboutUsBinding
import de.tobe.mobile.page_home.FirstFragment
import de.tobe.mobile.page_home.HomeActivity

class AboutUsActivity : AppCompatActivity() {

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
            replace(R.id.nav_host_fragment_content_main, TwentiethFragment())
            setReorderingAllowed(true)
            addToBackStack(null) // Name can be null
        }
        binding.buttonFirst.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, TwentiethFragment())
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
            is TwentiethFragment -> 0
            is TwentyfirstFragment -> 1
            is TwentysecondFragment -> 2
            is TwentythirdFragment -> 3
            is TwentyfourthFragment -> 4
            is TwentyfifthFragment -> 5
            is TwentysixthFragment -> 6
            else -> null
        }
        return fragmentNr
    }

    private fun getNext(current: Int?): Fragment {
        return current?.let {
            val next = it + 1
            if (next < 7) {
                fragmentFromNr(next)
            } else {
                TwentysixthFragment()
            }
        } ?: FirstFragment()
    }

    private fun getPrev(current: Int?): Fragment {
        return current?.let {
            val prev = it - 1
            fragmentFromNr(prev)
        } ?: TwentiethFragment()
    }

    private fun fragmentFromNr(nr: Int): Fragment? {
        return when (nr) {
            0 -> TwentiethFragment()
            1 -> TwentyfirstFragment()
            2 -> TwentysecondFragment()
            3 -> TwentythirdFragment()
            4 -> TwentyfourthFragment()
            5 -> TwentyfifthFragment()
            6 -> TwentysixthFragment()
            else -> null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.start -> {
                startActivity(Intent(this, HomeActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}