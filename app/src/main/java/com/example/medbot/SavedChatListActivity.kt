package com.example.medbot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SavedChatListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var savedChatList: MutableList<SavedChatListItem>
    private lateinit var savedChatListAdapter: SavedChatListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_chat_list)

        recyclerView = findViewById(R.id.saved_chat_scn_recyclerview)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@SavedChatListActivity)

        savedChatList.add(SavedChatListItem(title = "Demo Abc", filePath = "qwertyuiop"))
        savedChatList.add(SavedChatListItem(title = "Demo Xyz", filePath = "gjhfjgg"))
        savedChatList.add(SavedChatListItem(title = "Demo Pqr", filePath = "qwertyuiop"))
        savedChatList.add(SavedChatListItem(title = "Demo Sqt", filePath = "qwertyuiop"))
        savedChatList.add(SavedChatListItem(title = "Demo 123", filePath = "qwertyuiop"))

        savedChatListAdapter = SavedChatListAdapter(savedChatList)
        recyclerView.adapter = savedChatListAdapter


    }

}