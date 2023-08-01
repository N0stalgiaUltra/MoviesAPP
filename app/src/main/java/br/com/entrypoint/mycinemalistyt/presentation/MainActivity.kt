package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import br.com.entrypoint.mycinemalistyt.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val cardAdapter: CardAdapter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callPopularMovies()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Faz a binding do RecyclerView
        binding.mainRv.apply{
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = cardAdapter
        }

        mainViewModel.popularMovies.observe(this,){

            popularMovies -> cardAdapter.setMovies(popularMovies)
            /*
                popularMovies -> popularMovies.forEach {
                Log.i("movies", it.title)
            }*/
        }


    }

    private fun callPopularMovies(){
        GlobalScope.launch{
            mainViewModel.getPopularMovies()
        }
    }
}