package com.sheet.drivenext

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(favoriteObjectEntity: FavoriteCar)

    @Delete
    suspend fun deleteFavorite(favoriteObjectEntity: FavoriteCar)

    @Query("SELECT * FROM favorite_car")
    fun getAllFavorites(): Flow<List<FavoriteCar>>

    @Query("SELECT * FROM favorite_car WHERE carId = :carId")
    fun getFavoriteByObjectId(carId: Int): Flow<FavoriteCar?>

    @Query("SELECT EXISTS (SELECT 1 FROM favorite_car WHERE carId = :carId)")
    fun isFavorite(carId: Int): Flow<Boolean>
}