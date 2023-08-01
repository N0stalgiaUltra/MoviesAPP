package br.com.entrypoint.mycinemalistyt.presentation

import androidx.recyclerview.widget.RecyclerView
import br.com.entrypoint.mycinemalistyt.databinding.MovieCardBinding
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie

class CardViewHolder(
    private val movieCardBinding: MovieCardBinding
):RecyclerView.ViewHolder(movieCardBinding.root) {

    fun bindMovie(movie: PopularMovie){
        //Todo:Setar o cardImg com o Glide
        //movieCarBinding.cardImg =

        movieCardBinding.cardTitle.text = movie.title
        movieCardBinding.cardReleaseDate.text = movie.releaseDate
        movieCardBinding.cardVoteAvg.text = movie.voteAverage.toString()
    }
}