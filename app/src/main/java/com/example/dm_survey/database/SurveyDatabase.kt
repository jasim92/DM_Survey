package com.example.dm_survey.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dm_survey.dao.SurveyDao
import com.example.dm_survey.data.Survey
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Survey::class], version = 1)
abstract class SurveyDatabase: RoomDatabase() {
    abstract fun surveyDao(): SurveyDao

    companion object{

        private var INSTANCE: SurveyDatabase? = null

        private const val THREAD_POOL_SIZE = 4

        val surveyExecutor: ExecutorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE)

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): SurveyDatabase{
            return INSTANCE ?: synchronized(context){
                val instance = Room.databaseBuilder(context.applicationContext, SurveyDatabase::class.java
                    ,"survey_database")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }

        }
    }


}