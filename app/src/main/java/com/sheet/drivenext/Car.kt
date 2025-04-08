package com.sheet.drivenext

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="title") val title: String?,
    @ColumnInfo(name="brand") val brand: String?,
    @ColumnInfo(name="price") val price: Int?,
    @ColumnInfo(name="gearbox") val gearbox: String?,
    @ColumnInfo(name="energy") val energy: String?,
    @ColumnInfo(name="image") val image: String?
)