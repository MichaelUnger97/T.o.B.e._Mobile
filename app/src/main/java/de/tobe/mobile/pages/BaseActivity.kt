package de.tobe.mobile.pages

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import de.tobe.mobile.R
import de.tobe.mobile.pages.about_us.AboutUsActivity
import de.tobe.mobile.pages.become_member.BecomeMemberActivity
import de.tobe.mobile.pages.home.HomeActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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

            R.id.about_us -> {
                startActivity(Intent(this, AboutUsActivity::class.java))
                true
            }

            R.id.become_member -> {
                startActivity(Intent(this, BecomeMemberActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}