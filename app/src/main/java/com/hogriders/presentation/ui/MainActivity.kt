package com.hogriders.presentation.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hogriders.daggerexample.R
import com.hogriders.presentation.vm.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this)[MainActivityViewModel::class.java]

        //viewModel.insertUser(User(name = "asd", age = 20))
        viewModel.users.observe(this){ users ->
                val sb = StringBuilder()
                users.forEach { sb.append(it.toString()); sb.append("\n") }
                findViewById<TextView>(R.id.text_view)?.text = sb.toString()

        }
    }
}















