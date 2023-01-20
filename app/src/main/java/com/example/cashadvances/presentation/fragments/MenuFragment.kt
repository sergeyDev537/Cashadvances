package com.example.cashadvances.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cashadvances.R
import com.example.cashadvances.data.impl.PaydayLoansRepositoryImpl
import com.example.cashadvances.databinding.FragmentMenuBinding
import com.example.cashadvances.domain.usecases.GetInstallmentLoansUseCase
import com.example.cashadvances.domain.usecases.GetPrivacyPolicyUseCase
import com.example.cashadvances.domain.usecases.GetUrlLegalityUseCase
import com.example.cashadvances.domain.usecases.GetUrlPaydayLoansUseCase
import com.example.cashadvances.presentation.activities.MainActivity
import com.example.cashadvances.presentation.openUrl

class MenuFragment : Fragment() {

    private var mListener: IOnFragmentInteractionListener? = null
    private var paydayLoansRepository = PaydayLoansRepositoryImpl

    private var getUrlPaydayLoansUseCase = GetUrlPaydayLoansUseCase(paydayLoansRepository)
    private var getInstallmentLoansUseCase = GetInstallmentLoansUseCase(paydayLoansRepository)
    private var getUrlLegalityUseCase = GetUrlLegalityUseCase(paydayLoansRepository)
    private var getPrivacyPolicyUseCase = GetPrivacyPolicyUseCase(paydayLoansRepository)

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding ?: throw RuntimeException("FragmentMenuBinding is null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is IOnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException("$context must implement IOnFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibleButtons(mListener?.getArgs() ?: false)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.buttonPaydayLoans.setOnClickListener {
            openUrl(requireContext(), getUrlPaydayLoansUseCase.invoke())
        }
        binding.buttonInstallmentLoans.setOnClickListener {
            openUrl(requireContext(), getInstallmentLoansUseCase.invoke())
        }
        binding.buttonLoanCalculator.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_calculatorFragment)
        }
        binding.buttonAboutPayday.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_aboutPaydayFragment)
        }
        binding.buttonLegalityUs.setOnClickListener {
            openUrl(requireContext(), getUrlLegalityUseCase.invoke())
        }
        binding.buttonPrivacyPolicy.setOnClickListener {
            openUrl(requireContext(), getPrivacyPolicyUseCase.invoke())
        }
    }

    private fun visibleButtons(visibleMode: Boolean) {
        if (visibleMode) {
            binding.buttonPaydayLoans.visibility = View.VISIBLE
            binding.buttonInstallmentLoans.visibility = View.VISIBLE
        } else {
            binding.buttonPaydayLoans.visibility = View.GONE
            binding.buttonInstallmentLoans.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}