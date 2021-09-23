package com.hamburger.sampleandroidgroupie

import com.hamburger.sampleandroidgroupie.databinding.ListItemItemBinding
import com.xwray.groupie.databinding.BindableItem

class ItemListItem(private val item: Item) : BindableItem<ListItemItemBinding>() {
    override fun bind(viewBinding: ListItemItemBinding, position: Int) {
        viewBinding.also {
            it.name.text = item.name
            it.description.text = item.description
            it.price.text = item.price.toString()
        }
    }

    override fun getLayout(): Int {
        return R.layout.list_item_item
    }
}