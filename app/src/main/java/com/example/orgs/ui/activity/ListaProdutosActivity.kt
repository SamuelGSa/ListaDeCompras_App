package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()

    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        configuraRecycleView()
        configuraFab()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produto_fab)
        fab.setOnClickListener {
            vaiParaformularioProduto()
        }
    }

    private fun vaiParaformularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecycleView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produto_recyclerView)
        Log.i("MainActivity","onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = adapter
    }
}