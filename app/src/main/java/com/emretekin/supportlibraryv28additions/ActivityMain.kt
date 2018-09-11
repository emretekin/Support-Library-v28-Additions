package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.button.MaterialButton
import android.widget.Toast

class ActivityMain : AppCompatActivity() {

    private lateinit var bottomAppbar: MaterialButton
    private lateinit var materialButton: MaterialButton
    private lateinit var chip: MaterialButton
    private lateinit var chipGroup: MaterialButton
    private lateinit var materialCardview: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createViews()
        setListeners()
    }

    private fun createViews(){
        bottomAppbar = findViewById(R.id.sample_bottomAppbar_materialButton)
        materialButton = findViewById(R.id.sample_materialButton_materialButton)
        chip = findViewById(R.id.sample_chip_materialButton)
        chipGroup = findViewById(R.id.sample_chip_group_materialButton)
        materialCardview = findViewById(R.id.sample_materialcardview_materialButton)
    }

    private fun setListeners(){
        bottomAppbar.setOnClickListener {}
        materialButton.setOnClickListener {}
        chip.setOnClickListener {}
        chipGroup.setOnClickListener {}
        materialCardview.setOnClickListener {}
    }
}
