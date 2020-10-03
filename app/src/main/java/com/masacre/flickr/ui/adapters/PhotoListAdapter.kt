package com.masacre.flickr.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masacre.flickr.R
import com.masacre.flickr.extensions.inflate
import com.masacre.flickr.extensions.replaceContent
import com.masacre.flickr.model.Photo
import com.masacre.flickr.ui.holder.PhotoViewHolder

class PhotoListAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
    private val photos : MutableList<Photo> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val restaurantCellView = parent.inflate(R.layout.photo_view_holder, false)
        return PhotoViewHolder(restaurantCellView)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    fun updateRestaurants(newRestaurants: List<Photo>) {
        photos.replaceContent(newRestaurants)
        notifyDataSetChanged()
    }
}