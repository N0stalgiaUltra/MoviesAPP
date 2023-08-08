package br.com.entrypoint.mycinemalistyt.presentation

import br.com.entrypoint.mycinemalistyt.domain.PopularMovie

interface CardOnClick {
    fun onCardClick(movie: PopularMovie)
}