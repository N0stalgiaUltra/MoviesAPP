package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.entrypoint.mycinemalistyt.R
import br.com.entrypoint.mycinemalistyt.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), ImageLoader {

    private lateinit var binding: ActivityDetailBinding
    //Inicializar as principais variáveis do sistemas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Inicializar a UI por aqui
    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "Detail Activity is OnStart")
        changeText()
    }

    override fun onResume() {
        super.onResume()
        getMoviePoster()
    }

    private fun changeText(){
        binding.cardTitle.text = intent.getStringExtra("movie_title")
        binding.detailDescription.text = intent.getStringExtra("movie_overview")

        binding.cardVoteAvg.text = binding.root.context.getString(
            R.string.vote_average,
            intent.getDoubleExtra("movie_vote_avg", 0.0))

        binding.cardReleaseDate.text = binding.root.context.getString(
            R.string.release_date,
            intent.getStringExtra("movie_release_date"))
    }

    private fun getMoviePoster(){
        getImage(binding.cardImg, intent.getStringExtra("movie_poster")?: "")
    }

}