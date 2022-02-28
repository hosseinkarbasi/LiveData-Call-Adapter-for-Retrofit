package com.example.myapplicationtest

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationtest.network.NetworkManager
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img = findViewById<ImageView>(R.id.ig)

        NetworkManager.service.test(
            "1c04e05bce6e626247758d120b372a73",
            "flickr.photos.search",
            "flower",
            "url_s",
            "json",
            "1"
        ).observe(this) { t ->
            if (t != null) {
                if (t.isSuccess) {
                    Log.d("suc", t.resource.toString())
                    val url = t.resource?.photos?.photo?.get(0)?.url_s
                    Picasso.with(this@MainActivity)
                        .load(url)
                        .into(img)
                }
            }
        }
    }
}
