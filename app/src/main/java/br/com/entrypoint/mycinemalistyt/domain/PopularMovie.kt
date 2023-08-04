package br.com.entrypoint.mycinemalistyt.domain

//Padrão Mapper para o PopMovie
data class PopularMovie(
    val id: Long,
    val title: String,
    val overview: String,
    val voteAverage: Double,
    val releaseDate: String,
    val moviePoster: String
)
