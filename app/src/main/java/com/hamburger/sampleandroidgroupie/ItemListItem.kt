package com.hamburger.sampleandroidgroupie

import android.view.View
import com.hamburger.sampleandroidgroupie.databinding.ListItemItemBinding
import com.xwray.groupie.databinding.BindableItem

class ItemListItem(private val item: Item, private val itemListItemAction: ItemListItemAction) :
    BindableItem<ListItemItemBinding>() {
    override fun bind(viewBinding: ListItemItemBinding, position: Int) {
        viewBinding.also {
            it.name.text = item.name
            it.description.text = item.description
            it.price.text = item.price.toString()
            viewBinding.root.setOnClickListener {
                itemListItemAction.onClick(it, item)
            }
        }
    }

    override fun getLayout(): Int {
        return R.layout.list_item_item
    }
}

interface ItemListItemAction {
    fun onClick(view: View, item: Item)
}