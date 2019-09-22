package com.asmaa.retrofitwithkotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asmaa.retrofitwithkotlinsample.Network.MyAPI
import com.asmaa.retrofitwithkotlinsample.Network.RetrofitClient
import com.asmaa.retrofitwithkotlinsample.adapter.PostsAdapter
import com.asmaa.retrofitwithkotlinsample.model.Post
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: MyAPI

    internal lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance
        jsonApi=retrofit.create(MyAPI ::class.java)

        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager = LinearLayoutManager(this)

        fetchData();
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts->displayData(posts)}

        )
    }

    private fun displayData(posts: List<Post>?) {

        val adapter = PostsAdapter(this ,posts !!)
        recycler_posts.adapter = adapter
    }
}
