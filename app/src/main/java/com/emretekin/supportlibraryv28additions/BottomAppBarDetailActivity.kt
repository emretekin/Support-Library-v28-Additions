package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView

class BottomAppBarDetailActivity : AppCompatActivity() {

    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar_detail)

        createViews()
        setValues()
        setListeners()
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.bottom_appbar))
    }

    private fun createViews() {
        toolbarTitle = findViewById(R.id.toolbar_title_textview);
        arrowImageview = findViewById(R.id.arrow_imageview);
    }

    private fun setListeners() {
        arrowImageview.setOnClickListener { onBackPressed() }
    }
}

