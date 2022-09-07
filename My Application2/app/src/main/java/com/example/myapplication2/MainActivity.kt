package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var pos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("Es lima capital de Peru?", true)
        questions.add(question)
        // o tambien de la siguiente manera:
        questions.add(Question("Es lima capital de Chile?", false))
        questions.add(Question("Es Piura capital de Chile?", false))
        questions.add(Question("Es Brasil capital de Chile?", false))
        questions.add(Question("Es Bogota capital de Chile?", true))
        questions.add(Question("Es Bs As capital de Chile?", false))
        questions.add(Question("Es Bs As capital de Argentina?", true))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val textView = findViewById<TextView>(R.id.tvQuestionCapital)
        val btNext = findViewById<Button>(R.id.btNext)

        textView.text = questions[pos].sentence

        btYes.setOnClickListener {
            if(questions[pos].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener {
            if(questions[pos].answer != true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNext.setOnClickListener {
            pos++
            textView.text = questions[pos].sentence
        }
    }
}