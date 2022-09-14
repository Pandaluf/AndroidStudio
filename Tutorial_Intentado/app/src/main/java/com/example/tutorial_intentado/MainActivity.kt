package com.example.tutorial_intentado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var heroes: ArrayList<SuperHeroe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heroes = ArrayList()
        heroes.add(SuperHeroe("Bruce Banner", "Batman", R.drawable.spiderman))
        initRecycler()
    }

    fun initRecycler(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val adapter = HeroAdapter(heroes)
        rvHeroes.adapter = adapter
    }
}