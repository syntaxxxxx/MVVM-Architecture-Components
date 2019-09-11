package com.example.mvvm_arch_components.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_arch_components.BuildConfig
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.data.entity.Movies
import com.example.mvvm_arch_components.utama.detail.Detail
import com.example.mvvm_arch_components.utils.view.displayImageOriginal
import com.example.mvvm_arch_components.utils.view.inflate
import com.example.mvvm_arch_components.utils.view.onClicked
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.startActivity

class MoviesAdapter(private val context: Context? = null, private val list: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder
    = ViewHolder(parent.inflate(R.layout.item_movies))

    @Suppress("USELESS_ELVIS")
    override fun getItemCount(): Int = list.size ?: 0

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.bindItem(list.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movies: Movies? = null

        fun bindItem(data: Movies?) {
            this.movies = data
            itemView.tv_title.text = data?.title
            itemView.tv_popularity.text = data?.popularity.toString()
            itemView.tv_release.text = data?.releaseDate
            displayImageOriginal(context!!, itemView.iv_poster, BuildConfig.IMAGES + data?.posterPath)
            itemView.onClicked {
                itemView.context.startActivity<Detail>("movies" to movies)
            }
        }
    }
}