package com.example.imagepicker

import android.Manifest
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pick_button.setOnClickListener {
            requestPermissions.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private var requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                launchActivity.launch("image/*")
            } else {
                Toast.makeText(this, "Por favor permita esta merda", Toast.LENGTH_LONG)
            }
        }

    var launchActivity =
        registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
                image_view.setImageURI(result)
        }

}