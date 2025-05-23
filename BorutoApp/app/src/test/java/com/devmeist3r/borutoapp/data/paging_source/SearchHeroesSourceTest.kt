package com.devmeist3r.borutoapp.data.paging_source

import androidx.paging.PagingSource.LoadParams
import androidx.paging.PagingSource.LoadResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import com.devmeist3r.borutoapp.data.remote.BorutoApi
import com.devmeist3r.borutoapp.data.remote.FakeBorutoApi
import com.devmeist3r.borutoapp.domain.model.Hero

@ExperimentalCoroutinesApi
class SearchHeroesSourceTest {
    private lateinit var borutoApi: BorutoApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        borutoApi = FakeBorutoApi()
        heroes = listOf(
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
    }

    @Test
    fun `Search api with existing hero name, expect single result, assert LoadResult_Page`() = runTest {
        val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sasuke")
        assertEquals<LoadResult<Int, Hero>>(
            expected = LoadResult.Page(
                data = listOf(heroes.first()),
                prevKey = null,
                nextKey = null
            ),
            actual = heroSource.load(
                params = LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @Test
    fun `Search api with existing hero name, expect multi result, assert LoadResult_Page`() = runTest {
        val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sa")
        assertEquals<LoadResult<Int, Hero>>(
            expected = LoadResult.Page(
                data = listOf(heroes.first(), heroes[2]),
                prevKey = null,
                nextKey = null
            ),
            actual = heroSource.load(
                params = LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() = runTest {
        val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "")
        val loadResult = heroSource.load(
            LoadParams.Refresh(
                key = null,
                loadSize = 3,
                placeholdersEnabled = false
            )
        )

        val result = borutoApi.searchHeroes("").heroes

        assertTrue { result.isEmpty() }
        assertTrue { loadResult is LoadResult.Page }
    }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() = runTest {
        val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Unknown")
        val loadResult = heroSource.load(
            LoadParams.Refresh(
                key = null,
                loadSize = 3,
                placeholdersEnabled = false
            )
        )

        val result = borutoApi.searchHeroes("Unknown").heroes

        assertTrue { result.isEmpty() }
        assertTrue { loadResult is LoadResult.Page }
    }
}
