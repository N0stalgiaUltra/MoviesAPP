package br.com.entrypoint.mycinemalistyt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.entrypoint.mycinemalistyt.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import org.koin.android.ext.android.bind

class DetailActivity : AppCompatActivity() {

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
        binding.cardVoteAvg.text = intent.getStringExtra("movie_vote_avg")
        binding.cardReleaseDate.text = intent.getStringExtra("movie_release_date")
    }

    private fun getMoviePoster(){
        /*HARDCODED FOR TEST USAGE ONLY!!! */
        val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"
        Glide
            .with(applicationContext)
            .load(IMAGE_PATH+intent.getStringExtra("movie_poster"))
            .into(binding.cardImg)

    }
}