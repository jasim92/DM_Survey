package com.example.dm_survey.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dm_survey.data.Survey

@Dao
interface SurveyDao {
    @Insert
    fun insert(survey: Survey)

    @Query("SELECT * FROM survey_table")
    fun getSurveyData(): LiveData<List<Survey>>

    @Query("DELETE FROM survey_table")
    fun deleteAllData()
}