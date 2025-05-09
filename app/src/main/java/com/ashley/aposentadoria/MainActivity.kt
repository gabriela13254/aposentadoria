package com.ashley.aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ashley.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("masculino","feminino")

        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinnerSexo.adapter= adapter

        binding.buttonCalcular.setOnClickListener{
            val sexoSelecionado = binding.spinnerSexo.selectedItem as String
            val idade = binding.editIdade.text.toString().toLongOrNull()

            if (idade == null) {
                binding.textviewResultado.text = "Por favor, insira uma idade válida"
                return@setOnClickListener
            }

            val idadeMinima = if (sexoSelecionado.trim() == "masculino") 65 else 62
            val anosRestantes = idadeMinima - idade

            if (anosRestantes <= 0) {
                binding.textviewResultado.text = "Você já pode se aposentar"
            } else {
                binding.textviewResultado.text = "Faltam $anosRestantes anos para você se aposentar"
            }





        }

    }
}