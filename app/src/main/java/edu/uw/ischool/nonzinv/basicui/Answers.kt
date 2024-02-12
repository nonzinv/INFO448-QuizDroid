package edu.uw.ischool.nonzinv.basicui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Answers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val userAnswer = intent.getStringExtra("userAnswer")
        val correctIndex = intent.getStringExtra("correctIndex")
        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val lastQuestion = intent.getBooleanExtra("lastQuestion", false)
        Log.d("userAnswer", "$userAnswer")
        Log.d("correctIndex", "$correctIndex")
        Log.d("correctAnswers", "$correctAnswers")
        Log.d("lastQuestion", "$lastQuestion")

        findViewById<TextView>(R.id.userAnswer).text = "Your answer was: $userAnswer"
        findViewById<TextView>(R.id.result).text = "The correct answer was: $correctIndex"
        findViewById<TextView>(R.id.score).text = "$correctAnswers out of 3 questions correct"

        findViewById<Button>(R.id.Next).apply {
            text = if (lastQuestion) "Finish" else "Next"
            setOnClickListener {
                if (lastQuestion) {
                    startActivity(Intent(this@Answers, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    })
                }
                finish()
            }
        }
    }
}