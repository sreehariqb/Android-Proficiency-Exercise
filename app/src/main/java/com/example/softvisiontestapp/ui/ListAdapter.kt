package com.example.softvisiontestapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.softvisiontestapp.R
import com.example.softvisiontestapp.data.model.Row
import com.squareup.picasso.Picasso

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {
    var rows = listOf<Row>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.title)
        val descriptionView: TextView = itemView.findViewById(R.id.description)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_view, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.titleView.setText(rows.get(position).title)
        holder.descriptionView.setText(rows.get(position).description)
        Picasso.get().load(rows.get(position).imageHref)
            .into(holder.imageView)
    }
}