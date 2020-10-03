package com.masacre.flickr.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.masacre.flickr.R
import com.masacre.flickr.ui.adapters.PhotoListAdapter
import com.masacre.flickr.viewmodel.PhotoListViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_photo_list.*
import javax.inject.Inject


class PhotoListActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var photosListViewModel: PhotoListViewModel
    lateinit var photoListAdapter: PhotoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)
        photosListViewModel.init()
        setupRecyclerView()

        photosListViewModel.getPhotoListLiveData()?.observe(this,
            {
                    photos ->
                loading.visibility = View.GONE
                if (photos.isNullOrEmpty()) {
                    noResults.visibility = View.VISIBLE
                } else {
                    noResults.visibility = View.GONE
                    photoListAdapter.updateRestaurants(photos)
                }
            })
    }

    private fun setupRecyclerView() {
        photoListAdapter = PhotoListAdapter()
        photoListView.layoutManager = GridLayoutManager(this, 4)
        photoListView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        photoListView.adapter = photoListAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        (menu.findItem(R.id.search).actionView as SearchView).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    photosListViewModel.search(query)
                    loading.visibility = View.VISIBLE
                    noResults.visibility = View.GONE
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            }

        )

        return true
    }

}