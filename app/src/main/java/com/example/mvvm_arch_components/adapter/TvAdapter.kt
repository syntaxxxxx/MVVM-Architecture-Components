package com.example.mvvm_arch_components.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_arch_components.BuildConfig
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.data.entity.Tv
import com.example.mvvm_arch_components.utils.view.displayImageOriginal
import com.example.mvvm_arch_components.utils.view.inflate
import com.example.mvvm_arch_components.utils.view.onClicked
import kotlinx.android.synthetic.main.item_movies.view.*

class TvAdapter(private val context: Context? = null, private val list: ArrayList<Tv>) :
    RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    fun updateData(dataTv: List<Tv>) {
        val diffResult = DiffUtil.calculateDiff(TvDiffCallback(dataTv, list))
        this.list.clear()
        this.list.addAll(dataTv)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_movies))

    @Suppress("USELESS_ELVIS")
    override fun getItemCount(): Int = list.size ?: 0

    override fun onBindViewHolder(holder: TvAdapter.ViewHolder, position: Int) {
        holder.bindItem(list.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movies: Tv? = null

        fun bindItem(data: Tv?) {
            this.movies = data
            itemView.tv_title.text = data?.name
            itemView.tv_popularity.text = data?.popularity.toString()
            displayImageOriginal(context!!, itemView.iv_poster, BuildConfig.IMAGES + data?.posterPath)
            itemView.onClicked {

            }
        }
    }
}