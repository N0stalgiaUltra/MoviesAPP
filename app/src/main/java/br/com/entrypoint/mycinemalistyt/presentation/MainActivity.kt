package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lifecycle", "OnCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        callPopularMovies()




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
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = cardAdapter
        }
    }
}