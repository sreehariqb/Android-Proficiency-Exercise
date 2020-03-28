package com.example.softvisiontestapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
        if(rows[position].title.isNullOrEmpty() && rows[position].description.isNullOrEmpty() &&
                rows[position].imageHref.isNullOrEmpty()) {
            //hide the row, when the data is empty
            holder.itemView.visibility = View.GONE
            //to avoid taking up empty space, make layout width and height zero
            holder.itemView.layoutParams = ConstraintLayout.LayoutParams(0, 0)
        } else {
            //make the item visible and add margin
            holder.itemView.visibility = View.VISIBLE
            //establish item view width, height and bottom margin
            val layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.bottomMargin = 8
            holder.itemView.layoutParams = layoutParams

            //bind data into the view
            holder.titleView.text = rows[position].title
            holder.descriptionView.text = rows[position].description
            Picasso.get().load(rows[position].imageHref)
                .into(holder.imageView)
        }
    }
}