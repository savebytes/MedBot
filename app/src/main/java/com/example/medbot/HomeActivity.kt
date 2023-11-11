package com.example.medbot

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.LayoutInflater
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var symptomsList: ArrayList<Symptoms>
    private lateinit var symptomsAdapter: SymptomsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity )

        symptomsList = ArrayList()

        symptomsList.add(Symptoms(R.drawable.acidity, "Acidity"))
        symptomsList.add(Symptoms(R.drawable.anxiety, "Anxiety"))
        symptomsList.add(Symptoms(R.drawable.asthma, "Asthma"))
        symptomsList.add(Symptoms(R.drawable.bodypain, "Body Pain"))
        symptomsList.add(Symptoms(R.drawable.cold, "Cold"))
        symptomsList.add(Symptoms(R.drawable.fever, "Fever"))
        symptomsList.add(Symptoms(R.drawable.flu, "Flu"))
        symptomsList.add(Symptoms(R.drawable.headache, "Headache"))
        symptomsList.add(Symptoms(R.drawable.high_bood_pressure , "High Blood pressure"))
        symptomsList.add(Symptoms(R.drawable.peroids, "Periods"))

        symptomsAdapter = SymptomsAdapter(symptomsList)
        recyclerView.adapter = symptomsAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.menu_newchat -> {
                Toast.makeText(this@HomeActivity, "New Chat menu selected!", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.menu_profile -> {
                Toast.makeText(this@HomeActivity, "Profile menu selected!", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_saved_chat -> {
                Toast.makeText(this@HomeActivity, "Saved chat menu selected!", Toast
                    .LENGTH_SHORT).show()
            }
            R.id.menu_feedback -> {
                Toast.makeText(this@HomeActivity, "Feedback menu selected!", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }

}