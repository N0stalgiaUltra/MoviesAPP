package br.com.entrypoint.mycinemalistyt.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

interface ImageLoader {

    fun getImage(imageView: ImageView, route: String)
    {
        if(route.isNotBlank()) {
            val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"
            Glide
                .with(imageView.context)
                .load(IMAGE_PATH + route)
                .into(imageView)
        }
    }
}