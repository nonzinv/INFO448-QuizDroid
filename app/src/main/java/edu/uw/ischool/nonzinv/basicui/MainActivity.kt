package edu.uw.ischool.nonzinv.basicui


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val topics = arrayListOf("Math", "Physics", "Superheroes")
        listView = findViewById(R.id.listview)
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, topics)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selected = topics[position]
            val intent = Intent(this@MainActivity, TopicsList::class.java).apply {
                putExtra("selected", selected)
            }
            startActivity(intent)
        }
    }
}