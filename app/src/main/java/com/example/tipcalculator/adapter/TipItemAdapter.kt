package com.example.tipcalculator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tipcalculator.R
import com.example.tipcalculator.model.Tip


class TipItemAdapter (private val context: Context,
                      private val dataSet: MutableList<Tip>): RecyclerView.Adapter<TipItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val listTextView: TextView = view.findViewById(R.id.list_item_title)
        val percentTextView: TextView = view.findViewById(R.id.list_item_percent)
        val tipTextView: TextView = view.findViewById(R.id.list_item_tip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.listTextView.text = item.title
        holder.percentTextView.text = "${item.tipAmount} %"
        holder.tipTextView.text = "${item.calculateTip()} \$"
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}