package com.example.mydialer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contentFragment = ContentFragment()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view,
                    contentFragment, null)
                .commit()
        }

        val searchString = findViewById<EditText>(R.id.et_search)
        searchString.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(request: Editable) {

            }
            override fun beforeTextChanged(request: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(request: CharSequence, start: Int,
                                       before: Int, count: Int) {
                contentFragment.search(request)
            }
        })
    }
}
