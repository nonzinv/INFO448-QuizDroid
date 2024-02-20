package edu.uw.ischool.nonzinv.basicui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizQuestions : AppCompatActivity() {
    private var currQuestion = 0
    private var correctAnswers = 0

    private lateinit var question: List<Quiz>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val topic = intent.getStringExtra("topic") ?: ""
        Log.d("QuizQuestions", "Received topic: $topic")

        question = QuizApp.topicRepo.getQuestions(topic)
        updateQuestion(question[0])

        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val radioGroup = findViewById<RadioGroup>(R.id.radiogroup)
            val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                return@setOnClickListener
            }

            if (currQuestion < question.size) {
                val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedIndex = radioGroup.indexOfChild(radioButton)
                val correctIndex = question[currQuestion].correctAns
                val userAnswer = question[currQuestion].choices[selectedIndex]

                if (selectedIndex == correctIndex) {
                    correctAnswers++
                }
                if (currQuestion == question.size) {
                    finish()
                } else {
                    updateQuestion(question[currQuestion])
                }

                val intent = Intent(this, Answers::class.java).apply {
                    putExtra("correctIndex", question[currQuestion].choices[correctIndex])
                    putExtra("lastQuestion", currQuestion == question.size - 1)
                    putExtra("userAnswer", userAnswer)
                    putExtra("correctAnswers", correctAnswers)
                }
                Log.d("QuizQuestions", "Last Question Flag: ${currQuestion == question.size - 1}")
                currQuestion++
                startActivity(intent)
            }
        }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            if (currQuestion > 0) {
                currQuestion--
                findViewById<Button>(R.id.submitButton).visibility = View.GONE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (currQuestion < question.size) {
            updateQuestion(question[currQuestion])
        }
    }

    private fun updateQuestion(question: Quiz) {
        val questionText: TextView = findViewById(R.id.question)
        val radioGroup: RadioGroup = findViewById(R.id.radiogroup)
        radioGroup.clearCheck()
        questionText.text = question.question
        findViewById<RadioButton>(R.id.one).text = question.choices[0]
        findViewById<RadioButton>(R.id.two).text = question.choices[1]
        findViewById<RadioButton>(R.id.three).text = question.choices[2]
        findViewById<RadioButton>(R.id.four).text = question.choices[3]
    }
}