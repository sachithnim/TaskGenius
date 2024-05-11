package com.example.taskgenius

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskgenius.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: TasksDatabaseHelper
    private lateinit var tasksAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)
        tasksAdapter = TaskAdapter(db.getAllTasks(), this)

        binding.taskRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.taskRecyclerView.adapter = tasksAdapter

        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        tasksAdapter.refreshData(db.getAllTasks())
    }
}