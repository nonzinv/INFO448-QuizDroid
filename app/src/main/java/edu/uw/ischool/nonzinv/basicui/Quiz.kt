package edu.uw.ischool.nonzinv.basicui

data class Quiz(
    val question: String,
    val choices: List<String>,
    val correctAns: Int
)