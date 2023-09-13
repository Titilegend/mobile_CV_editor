package com.example.mobilecveditorhngtask2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilecveditorhngtask2.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var editActivityBinding:ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        editActivityBinding = ActivityEditBinding.inflate(layoutInflater)
        val view = editActivityBinding.root
        setContentView(view)
        editActivityBinding.submitButton.setOnClickListener {

            val newName = editActivityBinding.editTextName.text.toString()
            val newRole = editActivityBinding.editTextRole.text.toString()
            val newDescription = editActivityBinding.editTextDescription.text.toString()
            val newSlack = editActivityBinding.editTextSlack.text.toString()
            val newGithub = editActivityBinding.editTextGithub.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("newName", newName)
            resultIntent.putExtra("newRole", newRole)
            resultIntent.putExtra("newDescription", newDescription)
            resultIntent.putExtra("newSlack", newSlack)
            resultIntent.putExtra("newGithub", newGithub)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()


        }
    }
}