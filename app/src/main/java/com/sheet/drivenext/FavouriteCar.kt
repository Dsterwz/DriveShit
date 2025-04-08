package com.sheet.drivenext

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_car",
    foreignKeys = [ForeignKey(
        entity = Car::class,
        parentColumns = ["id"],
        childColumns = ["carId"],
        onDelete = ForeignKey.CASCADE
    )], indices = [Index("carId")]
)
data class FavoriteCar(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val carId: Int
)
