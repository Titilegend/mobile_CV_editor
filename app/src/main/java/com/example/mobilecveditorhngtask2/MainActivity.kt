package com.example.mobilecveditorhngtask2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilecveditorhngtask2.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var mainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainBinding.editButton.setOnClickListener {
            val intent = Intent(this@MainActivity,EditActivity::class.java)
            startActivityForResult(intent, EDIT_REQUEST_CODE)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val newName = data?.getStringExtra("newName")
            val newRole = data?.getStringExtra("newRole")
            val newGithub = data?.getStringExtra("newGithub")
            val newSlack = data?.getStringExtra("newSlack")
            val newBio = data?.getStringExtra("newDescription")

            mainBinding.fullname.text = newName
            mainBinding.role.text = newRole
            mainBinding.githubHandle.text = newGithub
            mainBinding.slackHandle.text = newSlack
            mainBinding.description.text = newBio
        }
    }

    companion object {
        const val EDIT_REQUEST_CODE = 1
    }

}