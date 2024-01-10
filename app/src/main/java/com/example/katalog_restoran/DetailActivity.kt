package com.example.katalog_restoran

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView

    companion object {
        const val RESTAURANT_DATA = "DATA"
    }

    private fun initComponents() {
        imgPhoto = findViewById(R.id.img_item_photo)
        tvName = findViewById(R.id.tv_item_name)
        tvDescription = findViewById(R.id.tv_item_description)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(RESTAURANT_DATA, Restaurant::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(RESTAURANT_DATA)
        }

        if(data != null) {
            initComponents()
            imgPhoto.setImageResource(data.photo)
            tvName.text = data.name
            tvDescription.text = data.description
        }
    }
}