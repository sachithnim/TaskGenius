package com.example.taskgenius

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskgenius.databinding.ActivityAddTaskBinding
import com.example.taskgenius.databinding.ActivityMainBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TasksDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        binding.saveBtn.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val content = binding.contentEdit.text.toString()
//            val date = binding.dateEdit.text.toString()
//            val time = binding.timeEdit.text.toString()
//            val event = binding.eventEdit.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
//                val task = Task(0, title, content, date, time, event)
                val task = Task(0, title, content)
                db.insertTask(task)

                Toast.makeText(this, "Task Saved", Toast.LENGTH_SHORT).show()

                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}