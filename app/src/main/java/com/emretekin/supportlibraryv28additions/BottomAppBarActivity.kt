package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView

class BottomAppBarActivity : AppCompatActivity() {

    private lateinit var bottomAppbar: BottomAppBar;
    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        createViews()
        setValues()
        setListeners()
        setBottomBarMenu()

    }

    private fun createViews(){
        bottomAppbar = findViewById(R.id.bottom_appbar);
        toolbarTitle = findViewById(R.id.toolbar_title_textview);
        arrowImageview = findViewById(R.id.arrow_imageview);
    }

    private fun setValues(){
        toolbarTitle.setText(getString(R.string.bottom_appbar))
    }

    private fun setListeners(){
        arrowImageview.setOnClickListener { onBackPressed()}
    }

    private fun setBottomBarMenu(){
        bottomAppbar.replaceMenu(R.menu.bottom_appbar_menu)
    }
}
