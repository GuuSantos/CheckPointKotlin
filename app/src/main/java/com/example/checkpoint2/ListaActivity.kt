package com.example.checkpoint2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkpoint2.adapter.ItemAdapter
import com.example.checkpoint2.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(),ItemAdapter.OnProdutoClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        Log.i("DADOS", DataBase.carrinhoCompras.toString())
        val rvListaCompras:RecyclerView = findViewById(R.id.rvListaCompras)
        rvListaCompras.layoutManager = LinearLayoutManager(this)

        rvListaCompras.adapter = ItemAdapter(DataBase.carrinhoCompras,this)

        val fabCadastrarProduto:FloatingActionButton = findViewById(R.id.fabCadastraProduto)
        fabCadastrarProduto.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onProdutoClick(produtoPosition: Int) {
        val intent = Intent(this, VisualizarActivity::class.java)
        intent.putExtra("dados", DataBase.carrinhoCompras[produtoPosition])
        startActivity(intent)
    }
}