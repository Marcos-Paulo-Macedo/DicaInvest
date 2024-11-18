package br.unipar.dicainvest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TableAdapter(private val data: List<List<String>>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val column1: TextView = itemView.findViewById(R.id.text_column_1)
        val column2: TextView = itemView.findViewById(R.id.text_column_2)
        val column3: TextView = itemView.findViewById(R.id.text_column_3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_table_row, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val rowData = data[position]
        holder.column1.text = rowData[0]
        holder.column2.text = rowData[1]
        holder.column3.text = rowData[2]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}