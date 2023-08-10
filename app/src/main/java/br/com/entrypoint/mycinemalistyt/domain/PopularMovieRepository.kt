package br.com.entrypoint.mycinemalistyt.domain

import br.com.entrypoint.mycinemalistyt.data.remote.response.PopularMovieResponse
import retrofit2.Call

interface PopularMovieRepository {
    suspend fun getPopularMovies(): List<PopularMovie>
}