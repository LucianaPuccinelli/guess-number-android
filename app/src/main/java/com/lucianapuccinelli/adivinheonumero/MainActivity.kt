package com.lucianapuccinelli.adivinheonumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textoDigitarTentativa: EditText
    private lateinit var botaoAdivinhar: Button
    private lateinit var botaoReiniciar: Button
    private lateinit var textoMaiorMenor: TextView
    private lateinit var jogo: adivinheNumero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoDigitarTentativa = findViewById(R.id.textoDigitarTentativa)
        botaoAdivinhar = findViewById(R.id.botaoAdivinhar)
        botaoReiniciar = findViewById(R.id.botaoReiniciar)
        textoMaiorMenor = findViewById(R.id.textoMaiorMenor)
        jogo = adivinheNumero()

        botaoAdivinhar.setOnClickListener{
            checarTentativa()
        }
        botaoReiniciar.setOnClickListener{
            recomecarJogo()
        }
    }

    private fun checarTentativa() {
        val tentativa = textoDigitarTentativa.text.toString().toIntOrNull()
        if (tentativa != null) {
            val feedback = jogo.checarTentativa(tentativa)
            mostarFeedback(feedback)
            if (feedback.startsWith("Parabéns")) {
                botaoAdivinhar.isEnabled = false
                botaoReiniciar.visibility = Button.VISIBLE
            }
        } else {
            mostarFeedback("Por favor, insira um número válido.")
        }
    }

    private fun recomecarJogo() {
        jogo.recomecar()
        textoDigitarTentativa.text.clear()
        botaoAdivinhar.isEnabled = true
        botaoReiniciar.visibility = Button.GONE
        mostarFeedback("")
    }

    private fun mostarFeedback(message: String) {
        textoMaiorMenor.text = message
    }
}