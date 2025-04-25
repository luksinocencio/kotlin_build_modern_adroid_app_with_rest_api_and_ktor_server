package com.devmeist3r.borutoapp.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import javax.inject.*
import android.content.*
import com.devmeist3r.borutoapp.data.pref.*
import com.devmeist3r.borutoapp.domain.repository.*

@Module
@InstallIn(SingletonComponent::class)
object RepositoyModule {
    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context,
    ): DataStoreOperation {
        return DataStoreOperationImpl(context = context)
    }
}
