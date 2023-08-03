package br.com.entrypoint.mycinemalistyt.presentation

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.com.entrypoint.mycinemalistyt.R
import br.com.entrypoint.mycinemalistyt.databinding.MovieCardBinding
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie

class CardViewHolder(
    private val movieCardBinding: MovieCardBinding,
    private val context: Context
):RecyclerView.ViewHolder(movieCardBinding.root) {

    fun bindMovie(movie: PopularMovie){
        //Todo:Setar o cardImg com o Glide
        //movieCarBinding.cardImg =

        val releaseDateText = context.getString(R.string.release_date, movie.releaseDate)
        val voteAvgText = context.getString(R.string.vote_average, movie.voteAverage)

        movieCardBinding.cardTitle.text = movie.title
        movieCardBinding.cardReleaseDate.text = releaseDateText
        movieCardBinding.cardVoteAvg.text = voteAvgText
    }
}