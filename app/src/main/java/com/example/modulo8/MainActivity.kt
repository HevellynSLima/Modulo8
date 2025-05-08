package com.example.modulo8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


class MainActivity : AppCompatActivity() {
    var titulo: TextView? = null
    var nome:EditText? = null
    var tela:LinearLayout? = null
    var numClicks  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       titulo = findViewById<TextView>(R.id.boas_vindas)
        nome = findViewById<EditText>(R.id.nome)
        val botao = findViewById<Button>(R.id.botao)

         tela = findViewById(R.id.tela)

        botao.setOnClickListener {
            numClicks++

            atualizarInterface()
        }
        nome?.addTextChangedListener {
            titulo?.text = it?.toString()
        }

    }

    fun atualizarInterface(){
        val texto = nome?.text.toString()
        titulo?.text = " $texto - Clique n° $numClicks"

        when (numClicks % 3){
           0 -> tela?.background = getDrawable(R.drawable.fundo1)
           1 -> tela?.background = getDrawable(R.drawable.fundo2)
           2 -> tela?.background = getDrawable(R.drawable.fundo3)

        }
        numClicks = numClicks % 11

    }
}