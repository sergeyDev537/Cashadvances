package com.example.cashadvances.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cashadvances.databinding.ActivityMainBinding
import com.example.cashadvances.presentation.fragments.IOnFragmentInteractionListener

class MainActivity : AppCompatActivity(), IOnFragmentInteractionListener {

    private var visibleBoolean: Boolean = false
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        parseArguments()
    }

    private fun parseArguments() {
        visibleBoolean = intent.getBooleanExtra(EXTRA_VISIBLE, false)
    }

    companion object {

        const val EXTRA_VISIBLE = "EXTRA_VISIBLE"

        fun newIntentCode(context: Context, visible: Boolean): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_VISIBLE, visible)
            return intent
        }

    }

    override fun getArgs(): Boolean {
        return visibleBoolean
    }

}