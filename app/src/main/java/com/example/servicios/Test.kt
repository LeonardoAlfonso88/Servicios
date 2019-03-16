package com.example.servicios

import retrofit2.Call
import retrofit2.Callback

class Test: ApiService
{
    override fun getAllPosts(): Call<List<Post>> {

    }

    override fun getPostById(id: Int): Call<Post> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun<T> Call<T>.enqueue(callback: CallBackKt.() -> Unit) {}

}