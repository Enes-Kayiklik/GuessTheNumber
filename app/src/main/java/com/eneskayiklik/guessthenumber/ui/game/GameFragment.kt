package com.eneskayiklik.guessthenumber.ui.game

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eneskayiklik.guessthenumber.R
import com.eneskayiklik.guessthenumber.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment: Fragment(R.layout.fragment_game) {
    private lateinit var gameViewModel: GameViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupButtonsOnClick()
    }

    private fun setupButtonsOnClick() {
        btnGuess.setOnClickListener {
            controlTheNumber()
        }
    }

    private fun controlTheNumber() {
        val guessedNumber = edtGuessedNumber.text.toString()
        val realNumber = gameViewModel.number.value!!

        when {
            guessedNumber.length < 4 -> {
                makeToast("Girdiğiniz Sayı 4 Basamaklı Olmalı")
            }
            guessedNumber[0] == '0' -> {
                makeToast("İlk Basamak 0 Olamaz")
            }
            else -> {
                when {
                    guessedNumber.toInt() < realNumber -> {
                        makeToast("${realNumber - guessedNumber.toInt()} Ekle")
                    }
                    guessedNumber.toInt() > realNumber -> {
                        makeToast("${guessedNumber.toInt() - realNumber} Çıkar")
                    }
                    else -> makeToast("Tebrikler!")
                }
            }
        }
    }

    private fun setupViewModel() {
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
    }

    private fun makeToast(string: String, length: Int = Toast.LENGTH_SHORT) {
        val toast = Toast.makeText(this.requireContext(), string, length)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}