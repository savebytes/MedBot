package com.example.medbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SymptomsAdapter(private val symtomsList:ArrayList<Symptoms>)
    : RecyclerView.Adapter<SymptomsAdapter.SymtomsViewHolder>() {

    class SymtomsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.card_img_view)
        val textView:TextView = itemView.findViewById(R.id.card_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymtomsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return SymtomsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return symtomsList.size
    }

    override fun onBindViewHolder(holder: SymtomsViewHolder, position: Int) {
        val symptoms = symtomsList[position]
        holder.imageView.setImageResource(symptoms.image)
        holder.textView.text = symptoms.name
    }
}