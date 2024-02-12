package edu.uw.ischool.nonzinv.basicui

class MemoryTopicsRepo: TopicRepository {
    private val topics = mutableListOf<Topic>()

    init {
        topics.add(
            Topic(
                "Math",
                "Math Quiz",
                "Here are 3 questions about math. Goodluck!",
                listOf(
                    Quiz("3x + 5 = 2x - 12, What is x?", listOf("15", "16", "17", "18"), 2),
                    Quiz("If a triangle has sides of 3 and 4, what is the length of the hypotenuse?", listOf("3", "4", "5", "25"), 2),
                    Quiz("2 to the power of what is 32?", listOf("5", "6", "2.5", "3.141592"), 0)
                )
            )
        )

        topics.add(
            Topic(
                "Physics",
                "Physics Quiz",
                "Here are 3 Questions about physics. Eureka!",
                listOf(
                    Quiz("What is the first law of thermodynamics?", listOf("Gauss's law", "Law of conservation of energy", "Faraday's Law", "Law of entropy"), 1),
                    Quiz("Who came up with the E=mc^2 equation?", listOf("J Robert Oppenheimer", "Niels Bohr", "Hans Bethe", "Albert Einstein"), 3),
                    Quiz("What does a dying star become?", listOf("Black Hole", "Planets", "Asteroids", "Shooting Star"), 0)
                )
            )
        )

        topics.add(
            Topic(
                "Marvel",
                "Marvel Quiz",
                "Here are 3 Marvel Questions!",
                listOf(
                    Quiz("Which actor played Gorr the God Butcher?", listOf("Christian Bale", "Matthew McConaughey", "Casey Affleck", "Jake Gyllenhaal"), 0),
                    Quiz("Who was not part of the original Avengers?", listOf("Vision", "Hawkeye", "Black Widow", "Nick Fury"), 0),
                    Quiz("Mysterio was a former employee of whom?", listOf("SHIELD", "Stark Industries", "HYDRA", "CIA"), 1)
                )
            )
        )
    }
    override fun getTopics(): List<Topic> {
        return topics
    }

    override fun getName(title: String): Topic? {
        return topics.find {it.title == title}
    }

    override fun getString(): List<String> {
        return topics.map {it.title}
    }

    override fun getQuestions(title: String): List<Quiz> {
        return topics.find { it.title == title }?.questions ?: emptyList()
    }
}