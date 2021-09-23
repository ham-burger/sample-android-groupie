package com.hamburger.sampleandroidgroupie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamburger.sampleandroidgroupie.databinding.ActivityMainBinding
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items by lazy {
        (1..100).map {
            Item(it, "name-$it", "description-$it", it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.text.text = "hello!"
        val adapter = GroupieAdapter()
        val listItems = items.map {
            ItemListItem(it)
        }
        adapter.addAll(listItems)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}