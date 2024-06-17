package com.example.alert_application

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alert_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.btnnext?.setOnClickListener {
            if (binding?.etnumber?.text.toString().trim().isNullOrEmpty()) {
                binding?.etnumber?.error = "enter any number"
            } else {
                var number = binding?.etnumber?.text.toString().toDouble()?:0.0
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Edit the your number")
                alertDialog.setMessage("add ${binding?.etnumber?.text}")
                alertDialog.setCancelable(false)

                alertDialog.setPositiveButton("add") { _, _ ->
                    binding?.etnumber?.setText((number+number).toString())
                    Toast.makeText(this, "Positive Clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.setNegativeButton("minus") { _, _ ->
                    binding?.etnumber?.setText((number-number).toString())
                    Toast.makeText(this, "negitive Clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.setNeutralButton("reset") { _, _ ->
                    binding?.etnumber?.setText((number-number).toString())
                    Toast.makeText(this, "Neutral Clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.show()
            }
        }

    }
}
