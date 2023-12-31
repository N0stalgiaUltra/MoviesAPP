package br.com.entrypoint.mycinemalistyt.data.remote.dto

import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import com.google.gson.annotations.SerializedName

data class PopularMovieDto(
    val id: Long,
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("poster_path")
    val moviePoster: String
){
    fun toPopularMovie(): PopularMovie{
        return PopularMovie(
            id = id,
            title = title,
            overview = overview,
            voteAverage = voteAverage,
            releaseDate = releaseDate,
            moviePoster = moviePoster
        )
    }
}
