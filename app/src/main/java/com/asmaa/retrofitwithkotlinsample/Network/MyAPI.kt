package com.asmaa.retrofitwithkotlinsample.Network

import com.asmaa.retrofitwithkotlinsample.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface MyAPI
{
    @get:GET("posts")
    val posts:Observable<List<Post>>

}