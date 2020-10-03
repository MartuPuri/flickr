package com.masacre.flickr.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.masacre.flickr.R
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.fullscreen_image.*

class FullScreenImageActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_image)
        val url = intent.getStringExtra(IMAGE_URL)
        Picasso.with(this).load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(fullscreenImage)
    }

    companion object {
        private const val IMAGE_URL = "image_url"

        fun createIntent(context : Context, url : String) : Intent{
            return Intent(context, FullScreenImageActivity::class.java).apply { putExtra(IMAGE_URL, url) }
        }
    }
}