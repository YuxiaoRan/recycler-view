package com.example.recycler_view_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entry.*

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        enterbutton.setOnClickListener {
            jumpToRecyclerView()
        }
    }

    private fun jumpToRecyclerView() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}