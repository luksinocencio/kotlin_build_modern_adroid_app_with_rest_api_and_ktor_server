package com.devmeist3r.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import com.devmeist3r.borutoapp.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

@OptIn(kotlinx.serialization.InternalSerializationApi::class)
@Serializable
@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)
