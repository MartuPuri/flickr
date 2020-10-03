package com.masacre.flickr.ui.holder

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.masacre.flickr.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_view_holder.view.*

class PhotoViewHolder(itemView: View) : ViewHolder(itemView) {
    private var zoomOut = false
    fun bind(photo: Photo) {
        Picasso.with(itemView.context).load(photo.url).into(itemView.image)
            itemView.image.setOnClickListener {
                if (zoomOut) {
                    itemView.image.layoutParams = RecyclerView.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    itemView.image.adjustViewBounds = true;
                    zoomOut = false;
                } else {
                    itemView.image.layoutParams = RecyclerView.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    );
                    itemView.image.scaleType = ImageView.ScaleType.FIT_XY;
                    zoomOut = true
                }
            }
    }
}