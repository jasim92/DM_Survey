package com.example.dm_survey.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.dm_survey.data.Survey
import com.example.dm_survey.repositories.SurveyRepository

class SurveyViewModel(application: Application): AndroidViewModel(application) {

    private val surveyRepository: SurveyRepository
    private val allSurveyData: LiveData<List<Survey>>

    init {
        surveyRepository = SurveyRepository(application)
        allSurveyData = surveyRepository.getSurveyData()
    }

    fun insert(survey: Survey){
        surveyRepository.insert(survey)
    }

    fun getSurveyData(): LiveData<List<Survey>> {
        return allSurveyData
    }

    fun deleteAllSurvey(){
        surveyRepository.delete()
    }
}