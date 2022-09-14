package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var heroes: ArrayList<Heroe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroes = ArrayList()
        heroes.add(Heroe("Batman", "Bruce Banner", "DC", R.drawable.batman))
        heroes.add(Heroe("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman))
        heroes.add(Heroe("Iron man", "Tony Stark", "Marvel", R.drawable.iron_man))
        heroes.add(Heroe("Superman","Clark Klen","DC", R.drawable.superman))
        heroes.add(Heroe("Wonder Woman","Diana Prince","DC",R.drawable.wonder_woman))
    }
}