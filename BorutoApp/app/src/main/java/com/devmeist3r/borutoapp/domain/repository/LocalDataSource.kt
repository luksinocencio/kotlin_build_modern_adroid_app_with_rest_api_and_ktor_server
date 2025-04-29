package com.devmeist3r.borutoapp.domain.repository

import com.devmeist3r.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}
