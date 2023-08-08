package br.com.entrypoint.mycinemalistyt.presentation

import android.content.Context
import android.media.Image
import androidx.recyclerview.widget.RecyclerView
import br.com.entrypoint.mycinemalistyt.R
import br.com.entrypoint.mycinemalistyt.databinding.MovieCardBinding
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import com.bumptech.glide.Glide

class CardViewHolder(
    private val movieCardBinding: MovieCardBinding,
    private val context: Context,
    private val onClick: CardOnClick
):RecyclerView.ViewHolder(movieCardBinding.root), ImageLoader {

    fun bindMovie(movie: PopularMovie){
        getImage(movieCardBinding.cardImg, movie.moviePoster)

        val releaseDateText = context.getString(R.string.release_date, movie.releaseDate)
        val voteAvgText = context.getString(R.string.vote_average, movie.voteAverage)

        movieCardBinding.cardTitle.text = movie.title
        movieCardBinding.cardReleaseDate.text = releaseDateText
        movieCardBinding.cardVoteAvg.text = voteAvgText

        movieCardBinding.movieCard.setOnClickListener {
            onClick.onCardClick(
                movie = movie
            )
        }
    }


}