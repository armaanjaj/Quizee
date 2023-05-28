package com.example.quizee

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        val que2 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "India",
            "Australia",
            "Armenia",
            "Austria",
            2
        )
        val que3 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "USA",
            "Belgium",
            "Armenia",
            "Austria",
            2
        )
        val que4 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "India",
            "Canada",
            "Brazil",
            4
        )
        val que5 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Australia",
            "Armenia",
            "Kuwait",
            1
        )
        val que6 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Italy",
            "Mexico",
            "Fiji",
            "Pakistan",
            3
        )
        val que7 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Russia",
            "Germany",
            "Jordan",
            "Nepal",
            2
        )
        val que8 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Iceland",
            "Chile",
            "India",
            "China",
            3
        )
        val que9 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "New Zealand",
            "Hungary",
            "Ukraine",
            1
        )
        val que10 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "South Africa",
            "New Zealand",
            "Australia",
            "United Kingdom",
            2
        )
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList
    }
}