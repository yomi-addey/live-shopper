package com.example.pocketshopper.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pocketshopper.Item
import com.example.pocketshopper.ItemApproval
import com.example.pocketshopper.ItemPriority

@Composable
fun Item(modifier: Modifier = Modifier, item: Item) {
    Box(modifier = modifier) {
        Column() {
            ItemLabel(item)
        }
    }
}

@Composable
private fun ItemLabel(item: Item) {
    Text(item.label, color = getPriorityColor(item.priority, item.approval))
}

@Composable
private fun getPriorityColor(priority: ItemPriority, approval: ItemApproval): Color {
    val opacity = getApprovalOpacity(approval)

    return when(priority) {
        ItemPriority.LOW -> Color.Yellow.copy(alpha = opacity)
        ItemPriority.MEDIUM -> Color(red = 1f, green = 0.5f, blue = 0f, alpha = opacity)
        ItemPriority.HIGH -> Color(red = 1f, green = 0f, blue = 0f, alpha = opacity)
        ItemPriority.NONE -> MaterialTheme.colorScheme.onPrimary.copy(alpha = opacity)
    }
}

private fun getApprovalOpacity(approval: ItemApproval): Float {
    return when(approval) {
        ItemApproval.PENDING -> 0.6f
        else-> 1f
    }
}