package com.emretekin.supportlibraryv28additions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.card.MaterialCardView

class MaterialCardviewActivity : AppCompatActivity() {

    private lateinit var mCardView: MaterialCardView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_cardview)

        mCardView = findViewById(R.id.mCardView);
        mCardView.setOnClickListener {  }
    }
}
