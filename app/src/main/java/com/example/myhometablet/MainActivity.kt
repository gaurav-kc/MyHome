package com.example.myhometablet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton = findViewById<Button>(R.id.Add_event_button)
        addButton.setOnClickListener {
            if(findNavController(R.id.fragment2).currentDestination?.id != R.id.add_event) {
                findNavController(R.id.fragment2).popBackStack(R.id.home_page, false)
                findNavController(R.id.fragment2).navigate(R.id.action_home_page_to_add_event)
            }
        }
        val addRecharge = findViewById<Button>(R.id.Add_recharge_button)
        addRecharge.setOnClickListener {
            if(findNavController(R.id.fragment2).currentDestination?.id != R.id.addRecharge) {
                findNavController(R.id.fragment2).popBackStack(R.id.home_page, false)
                findNavController(R.id.fragment2).navigate(R.id.action_home_page_to_addRecharge)
            }
        }

    }
}