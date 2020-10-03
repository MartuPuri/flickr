package com.masacre.flickr.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.masacre.flickr.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PhotoListActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        //TODO: Setup recyclert view with photos
    }

}