package com.eneskayiklik.guessthenumber.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eneskayiklik.guessthenumber.R

class SplashFragment: Fragment(R.layout.fragment_splash) {
    private lateinit var countDownTimer: CountDownTimer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUtils()
    }

    private fun setupUtils() {
        countDownTimer = object : CountDownTimer(1750L, 1000L) {
            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_gameFragment)
            }

            override fun onTick(p0: Long) {

            }
        }
    }

    override fun onStart() {
        super.onStart()
        countDownTimer.start()
    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }
}