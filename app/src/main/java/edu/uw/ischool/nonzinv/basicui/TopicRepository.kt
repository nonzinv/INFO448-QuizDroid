package edu.uw.ischool.nonzinv.basicui

interface TopicRepository {
    fun getTopics(): List<Topic>
    fun getName(title: String): Topic?
    fun getString(): List<String>
    fun getQuestions(title: String): List<Quiz>
}