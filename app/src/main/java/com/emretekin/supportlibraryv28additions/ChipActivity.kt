package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.chip.Chip
import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView

class ChipActivity : AppCompatActivity() {

    private lateinit var toolbarTitle: AppCompatTextView
    private lateinit var arrowImageview: ImageView;
    private lateinit var someChip: Chip;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chip)

        createViews()
        setValues()
        setListeners()
    }

    private fun createViews() {
        toolbarTitle = findViewById(R.id.toolbar_title_textview)
        arrowImageview = findViewById(R.id.arrow_imageview)
        someChip = findViewById(R.id.some_chip)

    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.chip))
    }

    private fun setListeners() {
        someChip.setOnClickListener { someChip.setCheckedIconResource(R.drawable.ic_android) }
        arrowImageview.setOnClickListener { onBackPressed() }
    }
}
