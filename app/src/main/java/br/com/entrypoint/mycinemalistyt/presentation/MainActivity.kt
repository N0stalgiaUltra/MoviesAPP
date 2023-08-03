package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import br.com.entrypoint.mycinemalistyt.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val cardAdapter: CardAdapter by inject()
    private var isConnected: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lifecycle", "OnCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "OnStart")
        setupRecyclerView()


    }
    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "OnResume")

        mainViewModel.popularMovies.observe(this,){
                popularMovies ->
                run {
                    cardAdapter.clearMovies()
                    cardAdapter.setMovies(popularMovies)
                    setupRecyclerView()
//                    popularMovies.forEach {
//                        Log.i("movies", it.title)
//                }
            }

        }

        if(!isConnected){
            callPopularMovies()
            isConnected = true
        }


    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "OnPause")

    }



    private fun callPopularMovies(){
        GlobalScope.launch{
            mainViewModel.getPopularMovies()
        }
    }

    private fun setupRecyclerView(){
        //Faz a binding do RecyclerView
        binding.mainRv.apply{
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = cardAdapter
        }
    }
}