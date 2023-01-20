package com.example.cashadvances.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cashadvances.databinding.FragmentCalculatorBinding
import com.example.cashadvances.presentation.viewModels.CalculateViewModel

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding: FragmentCalculatorBinding
        get() = _binding ?: throw RuntimeException("FragmentCalculatorBinding is null")

    private val calculateViewModel by lazy {
        ViewModelProvider(this)[CalculateViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        setTextChangedListeners()
    }

    private fun setObserver() {
        calculateViewModel.calculatePercents.observe(viewLifecycleOwner){
            binding.calculateItem = it
        }
    }

    private fun setTextChangedListeners() {
        binding.editTextLoanAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculate()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
        binding.editTextLoanTerm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculate()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
        binding.editTextInterestRate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculate()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

    }

    private fun calculate(){
        calculateViewModel.calculatePercent(
            binding.editTextLoanAmount.text.toString(),
            binding.editTextLoanTerm.text.toString(),
            binding.editTextInterestRate.text.toString()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}