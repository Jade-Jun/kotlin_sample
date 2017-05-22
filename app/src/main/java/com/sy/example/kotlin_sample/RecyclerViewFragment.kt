package com.sy.example.kotlin_sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by SuYa on 2017. 5. 22..
 */

class RecyclerViewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.let {
            val layoutManager = GridLayoutManager(activity, 3)

            recycler_view.layoutManager = layoutManager
            recycler_view.adapter = RecyclerViewAdapter(getDefalutItems())
        }
    }

    fun getDefalutItems() : ArrayList<String> {

        val items = ArrayList<String>()

        for (i in 0..200) {
            val item = "text_" + i
            items.add(item)
        }
        return items
    }

    inner class RecyclerViewAdapter(items : ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {

        val titles = items;

        override fun getItemCount(): Int {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return titles.size
        }

        override fun onBindViewHolder(p0: CustomViewHolder?, p1: Int) {

            //            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            val item = titles.get(p1)
            p0!!.title_view.text = item
        }

        override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): CustomViewHolder {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val view = LayoutInflater.from(p0?.context).inflate(R.layout.list_item, p0, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val title_view = view.title
        }

    }

}