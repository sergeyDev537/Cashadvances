package com.example.cashadvances.presentation.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cashadvances.databinding.ActivitySplashBinding
import com.example.cashadvances.presentation.showSnackbar
import com.example.cashadvances.presentation.viewModels.VisibleKeyViewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    private val visibleKeyViewModel by lazy {
        ViewModelProvider(this)[VisibleKeyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        visibleKeyViewModel.visibleKey.observe(this){
            nextActionCashAdvance(it)
        }
        visibleKeyViewModel.errorVisibleKey.observe(this){
            binding.root.showSnackbar(it)
        }
    }

    private fun nextActionCashAdvance(visible: Boolean) {
        startActivity(MainActivity.newIntentCode(this, visible))
        finish()
    }

}