package edu.uw.ischool.nonzinv.basicui

data class Topic(
    val title: String,
    val description: String,
    val detailedDesc: String,
    val questions: List<Quiz>
)