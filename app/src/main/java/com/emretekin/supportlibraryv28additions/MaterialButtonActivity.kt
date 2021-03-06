package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.button.MaterialButton
import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView
import android.widget.Toast

class MaterialButtonActivity : AppCompatActivity() {

    private lateinit var toolbarTitle: AppCompatTextView
    private lateinit var arrowImageview: ImageView;
    private lateinit var mButton1: MaterialButton;
    private lateinit var mButton2: MaterialButton;
    private lateinit var mButton3: MaterialButton;
    private lateinit var mButton4: MaterialButton;
    private lateinit var mButton5: MaterialButton;
    private lateinit var mButton6: MaterialButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_button)

        createViews()
        setValues()
        setListeners()
    }

    private fun createViews() {
        toolbarTitle = findViewById(R.id.toolbar_title_textview)
        arrowImageview = findViewById(R.id.arrow_imageview)
        mButton1 = findViewById(R.id.mButton1);
        mButton2 = findViewById(R.id.mButton2);
        mButton3 = findViewById(R.id.mButton3);
        mButton4 = findViewById(R.id.mButton4);
        mButton5 = findViewById(R.id.mButton5);
        mButton6 = findViewById(R.id.mButton6);
    }

    private fun setValues() {
        toolbarTitle.setText(getString(R.string.material_button))
    }

    private fun setListeners() {
        mButton1.setOnClickListener {  }
        mButton2.setOnClickListener {  }
        mButton3.setOnClickListener {  }
        mButton4.setOnClickListener {  }
        mButton5.setOnClickListener {  }
        mButton6.setOnClickListener {  }
        arrowImageview.setOnClickListener { onBackPressed() }
    }

}
