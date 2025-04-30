package com.devmeist3r.borutoapp.data.remote

import com.devmeist3r.borutoapp.domain.model.ApiResponse
import com.devmeist3r.borutoapp.domain.model.Hero

class FakeBorutoApi: BorutoApi {
    private val heroes = listOf(
        Hero(
            id = 1,
            name = "Sasuke Uchiha",
            image = "",
            about = "",
            rating = 5.0,
            power = 0,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        ),
        Hero(
            id = 2,
            name = "Naruto Uzumaki",
            image = "",
            about = "",
            rating = 5.0,
            power = 0,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        ),
        Hero(
            id = 3,
            name = "Sakura Haruno",
            image = "",
            about = "",
            rating = 5.0,
            power = 0,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        )
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(success = false)
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        val searchedHeroes = findHeroes(name = name)

        return ApiResponse(
            success = true,
            message = "ok",
            heroes = searchedHeroes
        )
    }

    private fun findHeroes(name: String): List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {
            heroes.forEach { hero ->
                if (hero.name.lowercase().contains(name.lowercase())) {
                    founded.add(hero)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}
