package br.com.entrypoint.mycinemalistyt.data.remote

import android.util.Log
import br.com.entrypoint.mycinemalistyt.data.remote.response.PopularMovieResponse
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import br.com.entrypoint.mycinemalistyt.domain.PopularMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.log

class PopularMovieRepositoryImpl(private val api: MoviesAPI): PopularMovieRepository {

    override suspend fun getPopularMovies(): List<PopularMovie> =
        suspendCoroutine{
            continuation -> run{
                val call: Call<PopularMovieResponse> = api.getPopularMovies()
                call.enqueue(
                    object : Callback<PopularMovieResponse> {
                        override fun onResponse(
                            call: Call<PopularMovieResponse>,
                            response: Response<PopularMovieResponse>
                        ) {
                            if (response.isSuccessful) {
                                val popMovies = response.body()?.popularMovies
                                Log.i("Repo", popMovies?.size.toString())
                                if (popMovies != null) {
                                    val mappedMovies = popMovies.map {
                                        it.toPopularMovie()
                                    }
                                    Log.i("Repo", mappedMovies.size.toString())
                                    continuation.resume(mappedMovies)
                                }
                            }
                        }

                        override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {
                            t.message?.let { Log.i("error", it) }
                            continuation.resume(emptyList())
                        }
                    }
                )
            }
         }

}

