package com.example.servicios

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PostAdapter(private val activity:
                  Activity, postList: List<Post>?) : BaseAdapter(){

    //Atributo
    private var postList = ArrayList<Post>()

    init {
        this.postList = postList as ArrayList<Post>
    }

    override fun getCount(): Int {
        return postList.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
        var vi : View
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.row_item, null)
        var userId = vi.findViewById<TextView>(R.id.userId)
        val title = vi.findViewById<TextView>(R.id.title)
        val body = vi.findViewById<TextView>(R.id.body)
        userId.text = postList[i].userId.toString()
        title.text = postList[i].title
        body.text = postList[i].body
        return vi
    }

}