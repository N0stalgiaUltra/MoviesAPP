package br.com.entrypoint.mycinemalistyt.data.remote

import br.com.entrypoint.mycinemalistyt.data.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("/3/movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ):Call<PopularMovieResponse>

    companion object{
        val BASE_URL = "https://api.themoviedb.org"
        val API_KEY = "41c1c3021c57207f4eefc5c90157f764"
    }
}

