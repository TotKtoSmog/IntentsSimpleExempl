package com.example.intent


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
       if(result.resultCode == 200){
           val str = result.data?.getStringExtra("Key2")
           Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
       }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            //неявное намерение
            val url = "https://mirea.ru"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            //явное намерение
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Key", "Hello from MainActivity!!!")
            //startActivity(intent) без возврата результата
            startForResult.launch(intent) // с возвратом результата
        }
    }
}