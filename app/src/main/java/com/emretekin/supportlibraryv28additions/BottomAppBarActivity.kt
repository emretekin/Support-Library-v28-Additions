package com.emretekin.supportlibraryv28additions

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.button.MaterialButton
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*
import kotlin.math.nextUp

class BottomAppBarActivity : AppCompatActivity() {

    private lateinit var bottomAppbar: BottomAppBar;
    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;
    private lateinit var fab: FloatingActionButton;
    private lateinit var fabAttachedButton: MaterialButton;
    private lateinit var fabAlignmentButton: MaterialButton;
    private lateinit var fabCradleVerticalOffsetButton: MaterialButton;
    private lateinit var decFabCradleVerticalOffsetButton: MaterialButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        createViews()
        setValues()
        setListeners()
        setBottomBarMenu()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(ContextCompat.getColor(applicationContext, R.color.gRed))
        }
    }

    private fun createViews() {
        bottomAppbar = findViewById(R.id.bottom_appbar);
        fab = findViewById(R.id.fab);
        toolbarTitle = findViewById(R.id.toolbar_title_textview);
        fabAttachedButton = findViewById(R.id.fabAttached_button);
        fabAlignmentButton = findViewById(R.id.fabAlignment_button);
        fabCradleVerticalOffsetButton = findViewById(R.id.fabCradleVerticalOffset_button);
        decFabCradleVerticalOffsetButton = findViewById(R.id.dec_fabCradleVerticalOffset_button);
        arrowImageview = findViewById(R.id.arrow_imageview);
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.bottom_appbar))
    }

    private fun setListeners() {
        Handler().postDelayed({
            // Anim
            bottomAppbar.toggleFabAttached()
        }, 500)
        Handler().postDelayed({
            // Anim
            bottomAppbar.toggleAlignment()
        }, 750)

        arrowImageview.setOnClickListener { onBackPressed() }
        fabAttachedButton.setOnClickListener { bottomAppbar.toggleFabAttached() }
        fabAlignmentButton.setOnClickListener { bottomAppbar.toggleAlignment() }
        fabCradleVerticalOffsetButton.setOnClickListener { bottomAppbar.increaseCradleVerticalOffset(30) }
        decFabCradleVerticalOffsetButton.setOnClickListener { bottomAppbar.increaseCradleVerticalOffset(0) }

        fab.setOnClickListener { goToSomewhere("https://medium.com/@emre.tekin/android-design-support-library-v28-3e0ea4d9f688") }
    }

    private fun setBottomBarMenu() {
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
            R.id.github -> goToSomewhere("https://github.com/emretekin/Support-Library-v28-Additions")
            R.id.material -> goToSomewhere("https://material.io/develop/android/components/bottom-app-bar/")
            R.id.about -> goToSomewhere("https://medium.com/@emre.tekin/android-design-support-library-v28-3e0ea4d9f688")
        }
        return true
    }

    private fun goToSomewhere(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    //My Extension Function for BottomAppBar
    fun BottomAppBar.toggleFabAttached() {
        if (bottomAppbar.isFabAttached) {
            bottomAppbar.setFabAttached(false)
        } else {
            bottomAppbar.setFabAttached(true)
        }
    }

    fun BottomAppBar.toggleAlignment() {
        val current = fabAlignmentMode
        fabAlignmentMode = current.xor(1)
    }

    fun BottomAppBar.increaseCradleVerticalOffset(value: Int) {
        bottomAppbar.setCradleVerticalOffset(value);
    }
}
