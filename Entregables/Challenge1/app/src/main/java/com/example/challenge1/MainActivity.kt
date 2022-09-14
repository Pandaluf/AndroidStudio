package com.example.challenge1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tvLifes: TextView
    lateinit var tvQuestion: TextView
    lateinit var tvTopic: TextView
    lateinit var btYes: Button
    lateinit var btNo: Button
    lateinit var btNext: Button
    lateinit var tvFinish: TextView

    lateinit var question: ArrayList<Question>

    var position: Int = 0
    var lifes: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLifes = findViewById(R.id.tvLifes)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvTopic = findViewById(R.id.tvTopic)
        btYes = findViewById(R.id.btYes)
        btNo = findViewById(R.id.btNo)
        btNext = findViewById(R.id.btNext)
        tvFinish = findViewById(R.id.tvFinish)

        question = ArrayList()
        question.add(Question("¿El coliseo Romano se encuentra en Grecia?","HISTORIA", false))
        question.add(Question("¿El Perú tiene 11 ecoregiones?","GEOGRAFÍA", true))
        question.add(Question("¿Son 12 la maravillas del mundo moderno?","HISTORIA", false))
        question.add(Question("¿Año luz es una unidad de medida?","FÍSICA", true))
        question.add(Question("¿Picaso dibujo la Mona Lisa?","ARTE", false))
        question.add(Question("¿Belazco Nuñez Vela fue el primer virrey del Perú?","HISTORIA", true))
        Game()
    }

    @SuppressLint("SetTextI18n")
    private fun Game(){

        tvLifes.text = "C C C"
        tvQuestion.text = question[position].question
        tvTopic.text = question[position].topic

        btYes.setOnClickListener {
            //PREGUNTAS
            if(question[position].result == true){
                Toast.makeText(this, "CORRECTO", Toast.LENGTH_LONG).show()
                btYes.isSelected = true
            }else{
                Toast.makeText(this, "INCORRECTO", Toast.LENGTH_LONG).show()
                lifes--
                btYes.isSelected = false
            }

            //Estados del Boton
            btNo.isEnabled = false
            btYes.isEnabled = false

            //VIDAS
            if(lifes == 3){
                tvLifes.text = "C C C"
            }else{
                if(lifes == 2){
                    tvLifes.text = "C C"
                }else{
                    if(lifes == 1){
                        tvLifes.text = "C"
                    }else{
                        //startActivity(Intent(this, Game_Over::class.java))
                        tvLifes.text = ""
                        btNext.isEnabled = false
                        tvFinish.text = "PERDISTES"
                    }
                }
            }
        }

        btNo.setOnClickListener{
            //PREGUNTAS
            if(question[position].result == false){
                Toast.makeText(this, "CORRECTO", Toast.LENGTH_LONG).show()
                btNo.isSelected = true
            }else{
                Toast.makeText(this, "INCORRECTO", Toast.LENGTH_LONG).show()
                lifes--
                btNo.isSelected = false
            }

            //Estados del Boton
            btNo.isEnabled = false
            btYes.isEnabled = false

            //VIDAS
            if(lifes == 3){
                tvLifes.text = "C C C"
            }else{
                if(lifes == 2){
                    tvLifes.text = "C C"
                }else{
                    if(lifes == 1){
                        tvLifes.text = "C"
                    }else{
                        tvLifes.text = ""
                        btNext.isEnabled = false
                        tvFinish.text = "PERDISTES"
                    }
                }
            }
        }

        btNext.setOnClickListener{
            position++
            if(position == 6){
                btNext.isEnabled = false
                tvFinish.text = "GANASTES"
            }else{
                tvQuestion.text = question[position].question
                tvTopic.text = question[position].topic
                btYes.isEnabled = true
                btNo.isEnabled = true
            }
        }
    }

}