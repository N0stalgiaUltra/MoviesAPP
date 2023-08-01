package br.com.entrypoint.mycinemalistyt.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.entrypoint.mycinemalistyt.databinding.MovieCardBinding
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie

class CardAdapter:
    RecyclerView.Adapter<CardViewHolder>() {

    private var movies: List<PopularMovie>? = null

    fun setMovies(movies: List<PopularMovie>?){
        Log.d("Adapter", "${this.movies?.size}, ${movies?.size}")
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val from = LayoutInflater.from(parent.context)
        val binding = MovieCardBinding.inflate(from, parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int{
        return movies?.size ?: 0
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val movie = movies?.get(position)
        if(movie != null)
            holder.bindMovie(movies?.get(position) ?: return)
    }
}

