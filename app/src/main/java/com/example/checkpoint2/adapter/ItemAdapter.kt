package com.example.checkpoint2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkpoint2.R
import com.example.checkpoint2.model.Produto
import java.text.FieldPosition

class ItemAdapter(val dados:List<Produto>, val onProdutoClickListener: OnProdutoClickListener):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View, val onProdutoClickListener: OnProdutoClickListener):RecyclerView.ViewHolder(view), View.OnClickListener{
        val tvItemNome:TextView = view.findViewById(R.id.tvItemNome)
        val tvItemMarca:TextView = view.findViewById(R.id.tvItemMarca)
        val cvItemLista:CardView = view.findViewById(R.id.cvItemLista)

        init{
            cvItemLista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onProdutoClickListener.onProdutoClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista,parent,false)
        return ItemViewHolder(adapterLayout, onProdutoClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val produto = dados[position]
        holder.tvItemNome.text = produto.nome
        holder.tvItemMarca.text = produto.marca
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    interface OnProdutoClickListener{
        fun onProdutoClick(produtoPosition: Int)
    }

}