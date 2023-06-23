package com.example.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.viewHolder>() {

    private val produtos = produtos.toMutableList()

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.produto_item_nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.produto_item_descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.produto_item_valor)
            valor.text = produto.valor.toPlainString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
