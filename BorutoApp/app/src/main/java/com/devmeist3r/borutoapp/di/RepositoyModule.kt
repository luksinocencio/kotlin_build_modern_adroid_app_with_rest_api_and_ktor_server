package com.devmeist3r.borutoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.content.Context
import com.devmeist3r.borutoapp.data.repository.DataStoreOperationsImpl
import com.devmeist3r.borutoapp.data.repository.Repository
import com.devmeist3r.borutoapp.domain.repository.DataStoreOperations
import com.devmeist3r.borutoapp.domain.use_cases.UseCases
import com.devmeist3r.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.devmeist3r.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.devmeist3r.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.devmeist3r.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.devmeist3r.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }
}
