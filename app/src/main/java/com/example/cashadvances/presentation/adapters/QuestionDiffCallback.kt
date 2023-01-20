package com.example.cashadvances.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cashadvances.domain.entities.QuestionAnswerItem

class QuestionDiffCallback: DiffUtil.ItemCallback<QuestionAnswerItem>() {
    override fun areItemsTheSame(
        oldItem: QuestionAnswerItem,
        newItem: QuestionAnswerItem
    ): Boolean {
        return oldItem.question == newItem.question
    }

    override fun areContentsTheSame(
        oldItem: QuestionAnswerItem,
        newItem: QuestionAnswerItem
    ): Boolean {
        return oldItem == newItem
    }
}