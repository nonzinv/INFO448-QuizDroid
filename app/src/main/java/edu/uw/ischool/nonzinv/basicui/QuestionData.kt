package edu.uw.ischool.nonzinv.basicui

object QuestionData {
    val mathQuestions = listOf(
        Questions("3x + 5 = 2x - 12, What is x?", listOf("15", "16", "17", "18"), 2),
        Questions("If a triangle has sides of 3 and 4, what is the length of the hypotenuse?", listOf("3", "4", "5", "25"), 2),
        Questions("2 to the power of what is 32?", listOf("5", "6", "2.5", "3.141592"), 0)
    )

    val physicsQuestions = listOf(
        Questions("What does a dying star become?", listOf("Black Hole", "Planets", "Asteroids", "Shooting Star"), 0),
        Questions("What is the first law of thermodynamics?", listOf("Gauss's law", "Law of conservation of energy", "Faraday's Law", "Law of entropy"), 1),
        Questions("Who came up with the E=mc^2 equation?", listOf("J Robert Oppenheimer", "Niels Bohr", "Hans Bethe", "Albert Einstein"), 3)
    )

    val marvelQuestions = listOf(
        Questions("Which actor played Gorr the God Butcher?", listOf("Christian Bale", "Matthew McConaughey", "Casey Affleck", "Jake Gyllenhaal"), 0),
        Questions("Who was not part of the original Avengers?", listOf("Vision", "Hawkeye", "Black Widow", "Nick Fury"), 0),
        Questions("Mysterio was a former employee of whom?", listOf("SHIELD", "Stark Industries", "HYDRA", "CIA"), 1)
    )
}

data class Questions(
    val question: String,
    val choices: List<String>,
    val correctAns: Int
)