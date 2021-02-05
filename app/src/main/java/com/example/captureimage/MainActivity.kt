package com.example.captureimage

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
       private const val picId = 123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //This Intent will help to open the camera for capturing the image.
            startActivityForResult(cameraIntent, picId)
            // Start the activity with camera_intent, and request pic id
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //use onActivityResult() method to get the result (here the captured image).
        super.onActivityResult(requestCode, resultCode, data)
        val img : ImageView = findViewById(R.id.image)
        if (requestCode== picId){
            val extras = data?.extras
            val imageBitmap = extras?.get("data") as Bitmap
            // BitMap is data structure of image file which store the image in memory
            img.setImageBitmap(imageBitmap)
            // Set the image in imageView for display
        }

    }
}