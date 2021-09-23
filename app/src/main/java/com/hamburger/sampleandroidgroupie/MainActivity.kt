package com.hamburger.sampleandroidgroupie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hamburger.sampleandroidgroupie.databinding.ActivityMainBinding
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity(), ItemListItemAction {
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
            ItemListItem(it, this)
        }
        adapter.addAll(listItems)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onClick(view: View, item: Item) {
        Snackbar.make(view, "メッセージ ${item.name}", Snackbar.LENGTH_SHORT).show();
    }


}