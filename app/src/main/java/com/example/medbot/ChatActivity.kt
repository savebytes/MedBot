package com.example.medbot

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


@Suppress("DEPRECATION")
class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter

    private val messageList = mutableListOf<MessageModel>()
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView = findViewById(R.id.chatrecyclerview)
        val messageEdittext = findViewById<EditText>(R.id.user_prompt_et)
        val sendBtn = findViewById<ImageButton>(R.id.send_btn)





        chatAdapter = ChatAdapter(messageList)

        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        recyclerView.layoutManager = llm
        recyclerView.adapter = chatAdapter


        sendBtn.setOnClickListener(){
            val question = messageEdittext.text.toString().trim()
            if (question.isNotEmpty()){
                sendMessage(question)
                messageEdittext.text.clear()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_scn_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.saved_ic -> {
                Toast.makeText(this@ChatActivity, "Hello This!", Toast.LENGTH_SHORT).show()
                saveChatInputDialog()
            }
        }
        return true
    }

    private fun saveChatInputDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.save_chat_dailog, null)
        alertDialogBuilder.setView(view)

        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            val editTextName = view.findViewById<EditText>(R.id.title_et)
            val chatTitle = editTextName.text.toString()

            if (chatTitle.isNotEmpty() && messageList.isNotEmpty()){
                ListToFileUtils.saveListToFile(this, "myList.txt", messageList)

                val filePath = ListToFileUtils.getSavedFilePath(this, "myList.txt")

                println("Saved file path: $filePath")

                ListToFileUtils.logFileContent(this, "myList.txt")
                Toast.makeText(this, "successful task$chatTitle!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Failed task", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss() // Dismiss the dialog
        }
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->

            dialog.dismiss() // Dismiss the dialog
        }

        // Create and show the AlertDialog
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun sendMessage(question: String) {
        messageList.add(MessageModel(question, "me"))
        messageList.add(MessageModel("I am good, how are you?", "bot"))
        chatAdapter.notifyDataSetChanged()
        recyclerView.smoothScrollToPosition(messageList.size - 1)
    }


}