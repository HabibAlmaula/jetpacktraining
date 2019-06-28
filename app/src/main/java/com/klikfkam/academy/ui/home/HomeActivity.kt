package com.klikfkam.academy.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.klikfkam.academy.R
import com.klikfkam.academy.ui.academy.AcademyFragment
import com.klikfkam.academy.ui.bookmark.BookmarkFragment

class HomeActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"
    private var navView: BottomNavigationView? = null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        var fragment: Fragment? = null
        if (item.itemId == R.id.action_home) {
            fragment = AcademyFragment.newInstance()
        } else if (item.itemId == R.id.action_bookmark) {
            fragment = BookmarkFragment.newInstance()
        }

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .commit()
        }
        true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navView = findViewById(R.id.nav_view)
        navView!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        savedInstanceState?.getInt(SELECTED_MENU) ?: navView!!.setSelectedItemId(R.id.action_home)


        // savedInstanceState?.getInt(SELECTED_MENU) ?: (navView!!.selectedItemId = R.id.action_home)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView!!.selectedItemId)
    }

}

