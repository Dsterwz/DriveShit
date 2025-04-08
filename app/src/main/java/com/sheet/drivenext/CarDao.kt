package com.sheet.drivenext

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(car: Car)

    @Update
    suspend fun update(car: Car)

    @Delete
    suspend fun delete(car: Car)

    @Query("SELECT * FROM car WHERE id = :id")
    fun getCarById(id: Int): Flow<Car>

    @Query("SELECT * FROM car")
    fun getAllCars(): Flow<List<Car>>

    @Query("DELETE FROM car")
    suspend fun deleteAllCars()
}