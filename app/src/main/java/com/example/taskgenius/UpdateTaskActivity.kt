package com.example.taskgenius

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.taskgenius.databinding.ActivityAddTaskBinding
import com.example.taskgenius.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db: TasksDatabaseHelper
    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        taskId = intent.getIntExtra("task_id", -1)
        if(taskId == -1){
            finish()
            return
        }

        val task = db.getTaskByID(taskId)
        binding.updateTitleEdit.setText(task.title)
        binding.updateContentEdit.setText(task.content)

        binding.updateSaveBtn.setOnClickListener {
            val newTitle = binding.updateTitleEdit.text.toString()
            val newContent = binding.updateContentEdit.text.toString()
            val updatedTask = Task(taskId, newTitle, newContent)

            db.updateTask(updatedTask)
            finish()

            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }

    }
}