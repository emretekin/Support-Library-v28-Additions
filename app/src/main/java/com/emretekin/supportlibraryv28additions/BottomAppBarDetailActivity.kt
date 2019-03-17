package com.emretekin.supportlibraryv28additions

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.button.MaterialButton
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView


class BottomAppBarDetailActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar;
    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;
    private lateinit var bottomAppbar: BottomAppBar;
    private lateinit var fab: FloatingActionButton;
    private lateinit var goDetail: MaterialButton;

    private val GITHUB_URL = "https://github.com/emretekin/Support-Library-v28-Additions";
    private val MEDIUM_URL = "https://medium.com/@emre.tekin/android-design-support-library-v28-3e0ea4d9f688";
    private val MATERIAL_IO_URL = "https://material.io/develop/android/components/bottom-app-bar";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar_detail)

        createViews()
        setValues()
        setListeners()
        setBottomBarMenu()
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.bottom_appbar))
    }

    private fun createViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title_textview);
        arrowImageview = findViewById(R.id.arrow_imageview);
        bottomAppbar = findViewById(R.id.bottom_appbar);
        fab = findViewById(R.id.fab);
        goDetail = findViewById(R.id.go_detail_materialButton);
    }

    private fun setListeners() {
        arrowImageview.setOnClickListener { onBackPressed() }
        goDetail.setOnClickListener {
            bottomAppbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            bottomAppbar.replaceMenu(R.menu.bottomappbar_menu_secondary)
            fab?.setImageDrawable(resources.getDrawable(R.drawable.ic_github))
        }
    }

    private fun setBottomBarMenu() {
//        setSupportActionBar(toolbar)
        bottomAppbar.replaceMenu(R.menu.bottom_appbar_menu)
        setSupportActionBar(bottomAppbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> openMenu()
            R.id.github -> goToSomewhere(GITHUB_URL)
            R.id.material -> goToSomewhere(MATERIAL_IO_URL)
            R.id.about -> goToSomewhere(MEDIUM_URL)
        }
        return true
    }

    private fun goToSomewhere(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun openMenu() {
        val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
        bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
    }
}

