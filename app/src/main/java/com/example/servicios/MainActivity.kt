package com.example.servicios

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service : ApiService
    val TAG_LOGS = "claseLeonardo"
    var adapter: PostAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<ApiService>(ApiService::class.java)
        getAllPosts(this)
        //getPostById(1)

    }

    fun getAllPosts(activity: Activity)
    {
        service.getAllPosts().enqueue(object: Callback<List<Post>> {
            override fun onResponse(call : Call<List<Post>>, response: Response<List<Post>>?)
            {
                val posts = response?.body()
                val listView : ListView = findViewById<ListView>(R.id.list_posts)
                adapter = PostAdapter(activity, posts)
                listView.adapter = adapter
                Log.i(TAG_LOGS, Gson().toJson(posts))
            }
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?)
            {
                t?.printStackTrace()
            }
        })
    }

    fun getPostById(id: Int)
    {
        service.getPostById(id).enqueue(object: Callback<Post>{
            override fun onResponse(call : Call<Post>?, response: Response<Post>?)
            {
                val post : Post = response?.body() as Post
                Log.i(TAG_LOGS, Gson().toJson(post))
            }
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }


}
