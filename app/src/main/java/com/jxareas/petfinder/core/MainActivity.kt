package com.jxareas.petfinder.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jxareas.petfinder.R
import com.jxareas.petfinder.core.domain.model.organization.Organization

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
