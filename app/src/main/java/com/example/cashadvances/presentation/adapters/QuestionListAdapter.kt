package com.example.cashadvances.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cashadvances.databinding.ItemQuestionBinding
import com.example.cashadvances.domain.entities.QuestionAnswerItem

class QuestionListAdapter :
    ListAdapter<QuestionAnswerItem, QuestionViewHolder>(QuestionDiffCallback()) {

    var clickQuestion: ((QuestionAnswerItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ItemQuestionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val binding = holder.binding
        binding.questionItem = getItem(position)
        binding.root.setOnClickListener {
            clickQuestion?.invoke(getItem(position))
        }
    }
}