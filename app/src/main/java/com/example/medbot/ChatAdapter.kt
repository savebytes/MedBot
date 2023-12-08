package com.example.medbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter (private val messageList:List<MessageModel>):
RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    inner class ChatViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var leftChatView = itemView.findViewById<LinearLayout>(R.id.left_chat_view)
        var rightChatView  = itemView.findViewById<LinearLayout>(R.id.right_chat_view)
        var leftTextView = itemView.findViewById<TextView>(R.id.left_chat_text_view)
        var rightTextView= itemView.findViewById<TextView>(R.id.right_chat_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ChatViewHolder, position: Int) {
        val message = messageList[position]
        if (message.sentBy == MessageModel.SENT_BY_ME) {
            holder.leftChatView.visibility = View.GONE
            holder.rightChatView.visibility = View.VISIBLE
            holder.rightTextView.text = message.message
        } else {
            holder.rightChatView.visibility = View.GONE
            holder.leftChatView.visibility = View.VISIBLE
            holder.leftTextView.text = message.message
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }


}