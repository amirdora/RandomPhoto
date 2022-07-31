package com.codewithamir.randomphoto

import android.app.WallpaperManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codewithamir.randomphoto.databinding.ActivityMainBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPhoto()

        binding.randomPhotoBtn.setOnClickListener {
            getPhoto()
        }

        binding.wallpaperButton.setOnClickListener{

            val bitmap = (binding.imageView.drawable as BitmapDrawable).bitmap

            if(bitmap!=null) {
                val wallpaperManager = WallpaperManager.getInstance(
                    applicationContext
                )
                wallpaperManager.setBitmap(bitmap)
            } else {
                Toast.makeText(applicationContext, "no image found", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun getPhoto() {
        Picasso.get()
            .load("https://source.unsplash.com/random/640x960")
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.imageView)
    }

}