package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMain2Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val data = bundle?.getString("Key")
        Snackbar.make(binding.constraintLayout, data.toString(), Snackbar.LENGTH_LONG).show()
        binding.button3.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Key2",binding.editTextTextPersonName.text.toString())
            setResult(200, intent)
            finish()
        }
    }
}