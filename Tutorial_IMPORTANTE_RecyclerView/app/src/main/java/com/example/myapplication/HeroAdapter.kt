package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class HeroAdapter(val superhero: List<Heroe>): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    lateinit var ivHeore: ImageView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superheroe, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int {
        return superhero.size
    }

    class HeroHolder(val view: View): RecyclerView.ViewHolder(view){
        fun render(superhero2: Heroe){

        }
    }
}