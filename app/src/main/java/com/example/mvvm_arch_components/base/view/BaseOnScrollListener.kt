package com.example.mvvm_arch_components.base.view

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class BaseOnScrollListener : RecyclerView.OnScrollListener {

    abstract fun onLoadMore(page : Int, totalItemCount : Int)

    private var CURRENT_PAGE = 0
    private var START_PAGE = 0
    private var PREVIOUS_TOTAL_ITEM_COUNT = 0
    private var LOAD_INITIAL = 10
    private var loading = false

    internal var layoutManager: RecyclerView.LayoutManager

    constructor(layoutManager: LinearLayoutManager) {
        this.layoutManager = layoutManager
    }

    constructor(layoutManager: GridLayoutManager) {
        this.layoutManager = layoutManager
        LOAD_INITIAL *= layoutManager.spanCount
    }

    constructor(layoutManager: StaggeredGridLayoutManager) {
        this.layoutManager = layoutManager
        LOAD_INITIAL *= layoutManager.spanCount
    }


    fun getLastVisibleItem(lastVisiblePosition: IntArray): Int {
        var size = 0
        for (i in lastVisiblePosition.indices) {
            if (i == 0) {
                size = lastVisiblePosition[i]
            } else if (lastVisiblePosition[i] > size) {
                size = lastVisiblePosition[i]
            }
        }
        return size
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = layoutManager.itemCount

        if (layoutManager is LinearLayoutManager) {
            lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

        } else if (layoutManager is GridLayoutManager) {
            lastVisibleItemPosition = (layoutManager as GridLayoutManager).findLastVisibleItemPosition()

        } else if (layoutManager is StaggeredGridLayoutManager) {
            val lastVisibleItemPositions =
                (layoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(null)
            lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
        }

        if (totalItemCount < PREVIOUS_TOTAL_ITEM_COUNT) {
            this.CURRENT_PAGE = this.START_PAGE
            this.PREVIOUS_TOTAL_ITEM_COUNT = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }

        if (loading && totalItemCount > PREVIOUS_TOTAL_ITEM_COUNT) {
            loading = false
            PREVIOUS_TOTAL_ITEM_COUNT = totalItemCount
        }

        if (loading && lastVisibleItemPosition + LOAD_INITIAL > totalItemCount) {
            CURRENT_PAGE++
            onLoadMore(CURRENT_PAGE, totalItemCount)
            loading = true
        }
    }
}