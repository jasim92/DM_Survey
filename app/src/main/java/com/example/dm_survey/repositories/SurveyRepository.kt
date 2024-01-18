package com.example.dm_survey.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.dm_survey.dao.SurveyDao
import com.example.dm_survey.data.Survey
import com.example.dm_survey.database.SurveyDatabase

 class SurveyRepository(application: Application) {

    private val surveyDao: SurveyDao
    private val allSurveyData: LiveData<List<Survey>>

    init {
        val surveyDatabase = SurveyDatabase.getInstance(application)
        surveyDao = surveyDatabase.surveyDao()
        allSurveyData = surveyDao.getSurveyData()
    }

    fun insert(survey: Survey){
        SurveyDatabase.surveyExecutor.execute{
            surveyDao.insert(survey)
        }
    }

    fun delete(){
        SurveyDatabase.surveyExecutor.execute{
            surveyDao.deleteAllData()
        }
    }

    fun getSurveyData(): LiveData<List<Survey>> {
        return allSurveyData
    }


}