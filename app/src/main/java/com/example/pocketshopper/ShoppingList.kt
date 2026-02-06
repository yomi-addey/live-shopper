package com.example.pocketshopper

class ShoppingList(
    private var owner: User,
    private val automaticApproval: Boolean = false
) : MyList {
    private val items: ArrayList<Item> = arrayListOf()

    fun changeOwner(newOwner: User) {
        owner = newOwner
    }

    override fun addItem(item: Item) {
        if (automaticApproval) {
            item.approval = ItemApproval.APPROVED
            items.add(item)
        } else {
            item.approval = ItemApproval.PENDING
            items.add(index = 0, element = item)
        }
    }

    override fun deleteItem(index: Int) {
        if (index !in items.indices) {
            throw IllegalArgumentException("Only ${items.size} item(s). Given index $index")
        }

        items.removeAt(index)
    }

    fun decideOnItem(itemIndex: Int, approved: Boolean) {
        if (itemIndex !in items.indices) {
            throw IllegalArgumentException("Only ${items.size} item(s). Given index $itemIndex")
        }

        items[itemIndex].approval = if (approved) ItemApproval.APPROVED else ItemApproval.REJECTED
    }
}