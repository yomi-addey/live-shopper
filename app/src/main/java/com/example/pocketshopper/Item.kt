package com.example.pocketshopper

import java.util.UUID

data class Item(
    var label: String,
    var quantity: Int = 1,
    var approval: ItemApproval = ItemApproval.NONE,
    var priority: ItemPriority = ItemPriority.NONE,
    var notes: String? = null,
    val requester: User? = null
) {
    private val iid: UUID = UUID.randomUUID()
}