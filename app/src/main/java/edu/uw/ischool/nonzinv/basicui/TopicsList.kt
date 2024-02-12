package edu.uw.ischool.nonzinv.basicui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TopicsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topicslist)

        val topic = intent.getStringExtra("selected") ?: ""
        val topicHeader = findViewById<TextView>(R.id.topic)
        val descriptions = findViewById<TextView>(R.id.description)

        val description = when (topic) {
            "Math" -> "Here are 3 Math Questions"
            "Physics" -> "Here are 3 Physics Questions"
            "Superheroes" -> "Here are 3 Marvel Trivia Questions"
            else -> ""
        }

        topicHeader.text = "$topic Quiz"
        descriptions.text = "$description"

        Log.d("TopicsList", "Selected topic: $topic")
        val beginButton = findViewById<Button>(R.id.btnBegin)
        beginButton.setOnClickListener {
            val intent = Intent(this, QuizQuestions::class.java).apply {
                putExtra("topic", topic)
            }
            startActivity(intent)
        }
    }
}