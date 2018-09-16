package com.emretekin.supportlibraryv28additions

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.button.MaterialButton
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.AppCompatTextView
import android.view.Menu
import android.widget.ImageView

class BottomAppBarActivity : AppCompatActivity() {

    private lateinit var bottomAppbar: BottomAppBar;
    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;
    private lateinit var fab: FloatingActionButton;
    private lateinit var fabAttachedButton: MaterialButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        createViews()
        setValues()
        setListeners()
        setBottomBarMenu()
    }

    private fun createViews() {
        bottomAppbar = findViewById(R.id.bottom_appbar);
        fab = findViewById(R.id.fab);
        toolbarTitle = findViewById(R.id.toolbar_title_textview);
        fabAttachedButton = findViewById(R.id.fabAttached_button);
        arrowImageview = findViewById(R.id.arrow_imageview);
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.bottom_appbar))
    }

    private fun setListeners() {
        Handler().postDelayed({
            bottomAppbar.setFabAttached(true)
        }, 500)

        arrowImageview.setOnClickListener { onBackPressed() }
        fabAttachedButton.setOnClickListener {
            if (bottomAppbar.isFabAttached) { bottomAppbar.setFabAttached(false) } else { bottomAppbar.setFabAttached(true) }
        }
    }

    private fun setBottomBarMenu() {
        bottomAppbar.replaceMenu(R.menu.bottom_appbar_menu)
    }
}
