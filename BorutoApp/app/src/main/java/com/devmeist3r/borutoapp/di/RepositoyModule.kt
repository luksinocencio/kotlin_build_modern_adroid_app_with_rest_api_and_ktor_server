package com.devmeist3r.borutoapp.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import javax.inject.*
import android.content.*
import com.devmeist3r.borutoapp.data.repository.*
import com.devmeist3r.borutoapp.domain.repository.*
import com.devmeist3r.borutoapp.domain.use_cases.*
import com.devmeist3r.borutoapp.domain.use_cases.read_onboarding.*
import com.devmeist3r.borutoapp.domain.use_cases.save_onboarding.*

@Module
@InstallIn(SingletonComponent::class)
object RepositoyModule {
    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context,
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }
}
