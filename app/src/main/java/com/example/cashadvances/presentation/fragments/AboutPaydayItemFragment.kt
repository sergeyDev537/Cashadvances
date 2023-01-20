package com.example.cashadvances.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.cashadvances.databinding.FragmentAboutPaydayItemBinding
import com.example.cashadvances.presentation.viewModels.AboutPaydayViewModel

class AboutPaydayItemFragment : Fragment() {

    private val args by navArgs<AboutPaydayItemFragmentArgs>()
    private val aboutPaydayViewModel: AboutPaydayViewModel by activityViewModels()
    private var _binding: FragmentAboutPaydayItemBinding? = null
    private val binding: FragmentAboutPaydayItemBinding
        get() = _binding ?: throw RuntimeException("FragmentAboutPaydayItemBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutPaydayItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutPaydayViewModel.getAnswerItem(args.nameQuestion)
        setObserve()
    }

    private fun setObserve() {
        aboutPaydayViewModel.answer.observe(viewLifecycleOwner){
            binding.textAnswer.text = it.answer
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}