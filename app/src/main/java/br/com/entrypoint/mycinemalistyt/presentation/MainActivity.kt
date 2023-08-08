package br.com.entrypoint.mycinemalistyt.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.entrypoint.mycinemalistyt.databinding.ActivityMainBinding
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), CardOnClick {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val cardAdapter: CardAdapter = CardAdapter(this)

    private var loadedContent: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lifecycle", "OnCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadedContent = false
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "OnStart")

        mainViewModel.popularMovies.observe(this,){
                popularMovies ->
            run {
                cardAdapter.clearMovies()
                cardAdapter.setMovies(popularMovies)

                if(cardAdapter.itemCount != 0)
                    binding.progressBar.visibility = View.INVISIBLE;

                setupRecyclerView()
            }
        }



    }
    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "OnResume")

        if(!loadedContent) {
            callPopularMovies()
            loadedContent = true
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "Main Activity is OnPause")

    }



    private fun callPopularMovies(){
        GlobalScope.launch{
            mainViewModel.getPopularMovies()
        }
    }

    private fun setupRecyclerView(){
        //Faz a binding do RecyclerView
        binding.mainRv.apply{
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = cardAdapter
        }
    }

    private fun getScreenTest(){
        Log.i("cards", "${66}")
    }

    override fun onCardClick(movie: PopularMovie) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("movie_title", movie.title)
        intent.putExtra("movie_overview", movie.overview)
        intent.putExtra("movie_release_date", movie.releaseDate)
        intent.putExtra("movie_vote_avg", movie.voteAverage)
        intent.putExtra("movie_poster", movie.moviePoster)
        startActivity(intent)
    }

}