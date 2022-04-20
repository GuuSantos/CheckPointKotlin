package com.example.checkpoint2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.checkpoint2.model.Produto

class CarrinhoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSaida: TextView = findViewById(R.id.tvSaida)
        val etNome: EditText = findViewById(R.id.etNome)
        val etMarca: EditText = findViewById(R.id.etMarca)
        val btAdicionar: Button = findViewById(R.id.btSomar)

        btAdicionar.setOnClickListener {
            cadastrarItem(etNome.text.toString(), etMarca.text.toString())
            esconderTeclado()

            etNome.text.clear()
            etMarca.text.clear()

            navegar()
        }
    }

    fun cadastrarItem(nome: String, marca: String) {
        DataBase.carrinhoCompras.add(Produto(nome = nome, marca = marca))
    }

    fun esconderTeclado() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view: View? = currentFocus
        imm.hideSoftInputFromWindow (view?.windowToken, 0)
    }

    fun navegar(){
        val intent = Intent(this, ListaActivity::class.java)
        startActivity(intent)
    }
}
