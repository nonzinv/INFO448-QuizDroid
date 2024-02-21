package edu.uw.ischool.nonzinv.basicui

import android.util.JsonReader
import java.io.FileReader

class MemoryTopicsRepo: TopicRepository {
     private val topics = mutableListOf<Topic>()

     init {
         topicsJson("/data/user/0/edu.uw.ischool.nonzinv.basicui/files/questions.json")
     }

    override fun getTopics(): List<String> {
        return topics.map {it.title}
    }

    override fun topicsJson(path: String) {
        JsonReader(FileReader(path)).use { reader ->
            reader.beginArray()
            while (reader.hasNext()) {
                topics.add(read(reader))
            }
            reader.endArray()
        }
    }

    override fun read(reader: JsonReader): Topic {
        var title = ""
        var desc = ""
        val questions = mutableListOf<Quiz>()
        reader.beginObject()
        while(reader.hasNext()) {
            when (reader.nextName()) {
                "title" -> title = reader.nextString()
                "desc" -> desc = reader.nextString()
                "questions" -> {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        questions.add(readQuiz(reader))
                    }
                    reader.endArray()
                }
            }
        }
        reader.endObject()
        return Topic(title, desc, desc, questions)
    }

    override fun readQuiz(reader: JsonReader): Quiz {
        var question = ""
        var correctIndex: Int = -1
        val choices = mutableListOf<String>()
        reader.beginObject()
        while(reader.hasNext()) {
            when(reader.nextName()) {
                "text" -> question = reader.nextString()
                "answer" -> correctIndex = reader.nextString().toInt()
                "answers" -> {
                    reader.beginArray()
                    while(reader.hasNext()) {
                        choices.add(reader.nextString())
                    }
                    reader.endArray()
                }
            }
        }
        reader.endObject()
        return Quiz(question, choices, correctIndex)
    }

    override fun getQuestions(title: String): List<Quiz> {
        return topics.find { it.title == title }?.questions ?: emptyList()
    }
}