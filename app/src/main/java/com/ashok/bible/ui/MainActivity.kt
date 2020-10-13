package com.ashok.bible.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ashok.bible.R
import com.ashok.bible.data.local.entry.BibleModelEntry
import com.ashok.bible.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.lakki.kotlinlearning.view.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(),
    HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var appBarConfigurationDrawerNavigation: AppBarConfiguration
    private lateinit var appBarConfigurationBottomNavigation: AppBarConfiguration


    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navView: BottomNavigationView = nav_view
        val navViewDrawer: NavigationView = nav_view_drawer

        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        appBarConfigurationBottomNavigation = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_highlights,
                R.id.navigation_bookmark,
                R.id.navigation_notes,
                R.id.navigation_settings
            )
        )
        appBarConfigurationDrawerNavigation = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_highlights,
                R.id.navigation_bookmark
            ),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfigurationBottomNavigation)
        setupActionBarWithNavController(navController, appBarConfigurationDrawerNavigation)
        navView.setupWithNavController(navController)
        navViewDrawer.setupWithNavController(navController)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        with(viewModel) {
            val list: ArrayList<BibleModelEntry> = ArrayList()
            val bibleModelEntry = BibleModelEntry()
            bibleModelEntry.title = "Test"
            list.add(bibleModelEntry)
            insertBible(list)
            carouselData.observe(this@MainActivity, Observer {
                if (it != null) {
                    Log.i("success", "success......" + it[0].mediaUrl)
                }
            })
        }
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentAndroidInjector
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfigurationDrawerNavigation) || super.onSupportNavigateUp()
    }
}
