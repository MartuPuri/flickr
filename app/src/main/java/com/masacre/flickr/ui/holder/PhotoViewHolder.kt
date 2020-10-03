package com.masacre.flickr.ui.holder

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.masacre.flickr.activities.FullScreenImageActivity
import com.masacre.flickr.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_view_holder.view.*

class PhotoViewHolder(itemView: View) : ViewHolder(itemView) {
    fun bind(photo: Photo) {
        Picasso.with(itemView.context).load(photo.url).into(itemView.image)
            itemView.image.setOnClickListener {
                itemView.context.startActivity(photo.url?.let { url ->
                    FullScreenImageActivity.createIntent(itemView.context,
                        url
                    )
                })
            }
    }
}