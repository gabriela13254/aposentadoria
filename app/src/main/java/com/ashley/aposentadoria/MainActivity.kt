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
            var idade = binding.editIdade.text.toString().toLongOrNull()
            var resultado: Long

            if (sexoSelecionado.trim()=="masculino"){
                resultado = 65 - idade!!

            }else{
                resultado = 62 - idade!!
            }

            binding.textviewResultado.text = "Faltam $resultado anos para você se aposentar"


        }

    }
}