package com.binar.mvp_staf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.mvp_staf.R
import com.binar.mvp_staf.model.GetAllStafResponseItem

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_staf_adapter.view.*


class RvAdapter(private var dataNews : List<GetAllStafResponseItem>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_staf_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.itemView.namaStaf.text = dataNews[position].name
        holder.itemView.tanggalStaf.text = dataNews!![position].createdAt
        holder.itemView.emailStaf.text = dataNews!![position].email
        Glide.with(holder.itemView.context).load(dataNews!![position].image).apply(RequestOptions().override(120, 120)).into(holder.itemView.imageStaf)





    }

    override fun getItemCount(): Int {
        if (dataNews == null){
            return 0
        }else{
            return dataNews!!.size

        }
    }
}