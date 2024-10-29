package br.unipar.dicainvest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RelatorioAdapter(private val relatorios: List<Relatorio>) : RecyclerView.Adapter<RelatorioAdapter.RelatorioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatorioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return RelatorioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatorioViewHolder, position: Int) {
        val relatorio = relatorios[position]
        holder.tituloTextView.text = relatorio.titulo
        holder.descricaoTextView.text = relatorio.descricao
    }

    override fun getItemCount(): Int {
        return relatorios.size
    }

    class RelatorioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloTextView: TextView = itemView.findViewById(android.R.id.text1)
        val descricaoTextView: TextView = itemView.findViewById(android.R.id.text2)
    }
}