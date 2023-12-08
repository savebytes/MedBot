package com.example.medbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SavedChatListAdapter (private val savedChatList:MutableList<SavedChatListItem>)
    :RecyclerView.Adapter<SavedChatListAdapter.SavedChatListViewHolder>(){
    class SavedChatListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById<TextView>(R.id.saved_chat_title_tv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SavedChatListAdapter.SavedChatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_chat_list_item, 
            parent, false)
        return SavedChatListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SavedChatListAdapter.SavedChatListViewHolder,
        position: Int
    ) {
        val savedListItem = savedChatList[position]
        holder.titleText.text = savedListItem.title
    }

    override fun getItemCount(): Int {
        return savedChatList.size
    }


}