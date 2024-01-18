package com.example.dm_survey.data


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dm_survey")
data class Survey(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val community: String,
    val restaurant_type: String,
    val area: Int,
    val area_type: String,
    val cctv_restaurant: Boolean,
    val count_cctv_restaurant: Int,
    val internet_available: Boolean,
    val internet_type: String,
    val cctv_kitchen: Boolean,
    val count_cctv_kitchen: Int,
    val smartphone_available: Boolean,
    val software_RMS: Boolean
)

