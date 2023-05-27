package com.example.quizee

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var btnSubmit: Button? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        // get the elements/views using their id
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        btnSubmit = findViewById(R.id.btn_submit)
        // options
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)

        // pass in this class as the parameter of the onClickListener because we inherited View.OnClickListener class, which makes the whole class active when user clicks the targeted option
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        // get the ArrayList from Constants file which contains all of the questions
        mQuestionsList = Constants.getQuestions()

        // call setQuestion() to hydrate the question skeleton with data
        setQuestion()
    }

    private fun setQuestion() {

        defaultOptionsView()

        // set the starting pointer to 0 in-order to read extract Question object
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        // change the text/message of the button based on the number of question
        if (mCurrentPosition == mQuestionsList!!.size)
            btnSubmit?.text = "Finish Quiz"
        else
            btnSubmit?.text = "Submit Answer"
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        // add the TextView's into an ArrayList, so that they all can be targeted using for loop to remove any kind of styling and make them look default
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        // for loop to remove any styling present on the TextView
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        // set the view to default mode i.e., un-selected
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        // target View based on the id of clicked element and style them accordingly
        when (view?.id) {
            R.id.tv_optionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_optionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_optionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_optionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++ // increment the pointer/counter to be ready for next question

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this, "You made it to the end!", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition)
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    // change the text/message of the button based on the number of question
                    if (mCurrentPosition == mQuestionsList!!.size)
                        btnSubmit?.text = "Finish Quiz"
                    else
                        btnSubmit?.text = "Go to next question"

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        var optionTextView: TextView? = null

        when (answer) {
            1 -> optionTextView = tvOptionOne
            2 -> optionTextView = tvOptionTwo
            3 -> optionTextView = tvOptionThree
            4 -> optionTextView = tvOptionFour
        }

        optionTextView?.background = ContextCompat.getDrawable(
            this, drawableView
        )
        optionTextView?.setTextColor(Color.parseColor("#FFFFFF"))
    }
}