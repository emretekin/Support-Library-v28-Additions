package com.emretekin.supportlibraryv28additions

import android.app.Activity
import android.content.ClipData.newIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.button.MaterialButton
import android.support.design.chip.Chip
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class ActivityMain : AppCompatActivity() {

    private lateinit var toolbar: Toolbar;
    private lateinit var toolbarTitle: AppCompatTextView;
    private lateinit var arrowImageview: ImageView;
    private lateinit var bottomAppbar: MaterialButton
    private lateinit var materialButton: MaterialButton
    private lateinit var chip: MaterialButton
    private lateinit var chipGroup: MaterialButton
    private lateinit var materialCardview: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createViews()
        setValues()
        setListeners()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(ContextCompat.getColor(applicationContext, R.color.gBlue))
        }
    }

    private fun createViews(){
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.toolbar_title_textview)
        arrowImageview = findViewById(R.id.arrow_imageview)
        bottomAppbar = findViewById(R.id.sample_bottomAppbar_materialButton)
        materialButton = findViewById(R.id.sample_materialButton_materialButton)
        chip = findViewById(R.id.sample_chip_materialButton)
        chipGroup = findViewById(R.id.sample_chip_group_materialButton)
        materialCardview = findViewById(R.id.sample_materialcardview_materialButton)
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.app_name))
        toolbar.hideBackButton()
    }

    private fun setListeners(){
        bottomAppbar.setOnClickListener { startActivity(Intent(this, BottomAppBarActivity::class.java)) }
        materialButton.setOnClickListener { startActivity(Intent(this, MaterialButtonActivity::class.java)) }
        chip.setOnClickListener { startActivity(Intent(this, ChipActivity::class.java)) }
        chipGroup.setOnClickListener { startActivity(Intent(this, ChipGroupActivity::class.java)) }
        materialCardview.setOnClickListener { startActivity(Intent(this, MaterialCardviewActivity::class.java)) }
    }

    fun Toolbar.hideBackButton() {
        arrowImageview.visibility = View.GONE;
    }
}
