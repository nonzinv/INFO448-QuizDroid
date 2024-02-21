package edu.uw.ischool.nonzinv.basicui
import android.util.JsonReader

interface TopicRepository {

    fun getTopics(): List<String>
    fun topicsJson(path: String)
    fun read(reader: JsonReader): Topic
    fun readQuiz(reader: JsonReader): Quiz
    fun getQuestions(title: String): List<Quiz>

}