package br.unipar.dicainvest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CalendarioActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tableAdapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf(
            listOf("ameixa", "junho", "setembro a outubro"),
            listOf("amendoim", "setembro", "janeiro a abril"),
            listOf("arroz", "setembro", "novembro a abril"),
            listOf("feijão", "novembro", "janeiro a fevereiro"),
            listOf("soja", "dezembro", "fevereiro a março")
        )
        tableAdapter = TableAdapter(data)
        recyclerView.adapter = tableAdapter
    }
}