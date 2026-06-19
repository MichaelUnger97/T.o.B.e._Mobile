package de.tobe.mobile.pages.home

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
import de.tobe.mobile.databinding.ActivityHomeBinding
import de.tobe.mobile.pages.about_us.AboutUsActivity

class HomeActivity : AppCompatActivity() {

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
            replace(R.id.nav_host_fragment_content_main, FirstFragment())
            setReorderingAllowed(true)
            addToBackStack(null) // Name can be null
        }
        binding.buttonFirst.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, FirstFragment())
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
            is FirstFragment -> 1
            is SecondFragment -> 2
            is ThirdFragment -> 3
            is FourthFragment -> 4
            is FifthFragment -> 5
            is SixthFragment -> 6
            is SeventhFragment -> 7
            is EightFragment -> 8
            is NinthFragment -> 9
            is TenthFragment -> 10
            is EleventhFragment -> 11
            is TwelvthFragment -> 12
            is ThirteenthFragment -> 13
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
                ThirteenthFragment()
            }
        } ?: FirstFragment()
    }

    private fun getPrev(current: Int?): Fragment {
        return current?.let {
            val prev = it - 1
            fragmentFromNr(prev)
        } ?: FirstFragment()
    }

    private fun fragmentFromNr(nr: Int): Fragment? {
        return when (nr) {
            1 -> FirstFragment()
            2 -> SecondFragment()
            3 -> ThirdFragment()
            4 -> FourthFragment()
            5 -> FifthFragment()
            6 -> SixthFragment()
            7 -> SeventhFragment()
            8 -> EightFragment()
            9 -> NinthFragment()
            10 -> TenthFragment()
            11 -> EleventhFragment()
            12 -> TwelvthFragment()
            13 -> ThirteenthFragment()
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
            R.id.about_us -> {
                startActivity(Intent(this, AboutUsActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}