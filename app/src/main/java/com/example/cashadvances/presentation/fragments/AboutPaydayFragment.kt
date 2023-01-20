package com.example.cashadvances.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cashadvances.databinding.FragmentAboutPaydayBinding
import com.example.cashadvances.presentation.adapters.QuestionListAdapter
import com.example.cashadvances.presentation.showSnackbar
import com.example.cashadvances.presentation.viewModels.AboutPaydayViewModel

class AboutPaydayFragment : Fragment() {

    private val aboutPaydayViewModel: AboutPaydayViewModel by activityViewModels()

    private val questionListAdapter by lazy {
        QuestionListAdapter()
    }

    private var _binding: FragmentAboutPaydayBinding? = null
    private val binding: FragmentAboutPaydayBinding
        get() = _binding ?: throw RuntimeException("FragmentAboutPaydayBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutPaydayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setObserve()
    }

    private fun setObserve() {
        aboutPaydayViewModel.questionList.observe(viewLifecycleOwner) {
            questionListAdapter.submitList(it)
        }
        aboutPaydayViewModel.errorQuestionList.observe(viewLifecycleOwner) {
            binding.root.showSnackbar(it)
        }
    }

    private fun setupAdapter() {
        questionListAdapter.clickQuestion = {
            findNavController().navigate(
                AboutPaydayFragmentDirections.actionAboutPaydayFragmentToAboutPaydayItemFragment2(
                    it.question
                )
            )
        }
        binding.rvAboutPayday.adapter = questionListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}