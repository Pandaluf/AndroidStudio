package com.example.tutorial_intentado

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_superheroes.view.*

class HeroAdapter(val superhero: List<SuperHeroe>): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superheroes, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int {
        return superhero.size
    }

    class HeroHolder(val view:View): RecyclerView.ViewHolder(view){
        @SuppressLint("UseCompatLoadingForDrawables")
        fun render(superhero: SuperHeroe){
            view.tvRealName.text = superhero.realName
            view.tvSuperheroName.text = superhero.superheroName
            view.ivHeroPicture.setImageDrawable(view.context.getDrawable(superhero.image))
        }
    }
}