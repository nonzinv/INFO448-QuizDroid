package edu.uw.ischool.nonzinv.basicui

import android.app.Application
import android.util.Log


class QuizApp: Application() {
    companion object {
        lateinit var topicRepo: TopicRepository
            private set
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("QuizApp", "Loading Questions")
        topicRepo = MemoryTopicsRepo()
    }
}