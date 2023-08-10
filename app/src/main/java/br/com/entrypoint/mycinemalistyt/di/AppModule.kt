package br.com.entrypoint.mycinemalistyt.di

import android.graphics.Movie
import br.com.entrypoint.mycinemalistyt.data.remote.MoviesAPI
import br.com.entrypoint.mycinemalistyt.data.remote.PopularMovieRepositoryImpl
import br.com.entrypoint.mycinemalistyt.domain.PopularMovieRepository
import br.com.entrypoint.mycinemalistyt.presentation.CardAdapter
import br.com.entrypoint.mycinemalistyt.presentation.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    //obj para interceptar chamadas HTTP
    factory <Interceptor> {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger.DEFAULT
        ).setLevel(
            HttpLoggingInterceptor.Level.HEADERS
        )
    }

    //cria o client
    factory {
        OkHttpClient.Builder().addInterceptor(
            interceptor = get()
        ).build()
    }

    //singleton, koin sabe criar uma instancia unica do Retrofit.
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(MoviesAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}

val apiModule = module {
    single (createdAtStart = false){
        get<Retrofit>().create(MoviesAPI::class.java)
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(
            repository = get()
        )
    }
}

val repositoryModule = module {
    single <PopularMovieRepository>{
        PopularMovieRepositoryImpl(api = get())
    }
}


