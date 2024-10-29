package br.unipar.dicainvest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RelatoriosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RelatorioAdapter
    private lateinit var relatorioList: MutableList<Relatorio>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorios)


        recyclerView = findViewById(R.id.recyclerView)
        val button: Button = findViewById(R.id.button)


        recyclerView.layoutManager = LinearLayoutManager(this)


        relatorioList = mutableListOf(
            Relatorio("Marco Raspini", "100 pontos"),
            Relatorio("Marcos Macedo", "95 pontos"),
            Relatorio("Ana Silveira", "85 pontos"),
            Relatorio("Daniel Mensor", "50 pontos")
        )

        adapter = RelatorioAdapter(relatorioList)
        recyclerView.adapter = adapter


        button.setOnClickListener {

        }
    }
}