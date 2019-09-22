package com.asmaa.retrofitwithkotlinsample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asmaa.retrofitwithkotlinsample.R
import com.asmaa.retrofitwithkotlinsample.model.Post
import java.lang.StringBuilder

class PostsAdapter (internal  var context: Context , internal var postsList:List<Post>)
    :RecyclerView.Adapter<PostViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.posts_layout , parent ,false)
        return PostViewHolder(itemview)
    }

    override fun getItemCount(): Int {
       return postsList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int)
    {
        holder.text_author.text = postsList[position].userId.toString()
        holder.text_title.text = postsList[position].userId.toString()
        holder.text_content.text = StringBuilder(postsList[position].body.substring(0,20))
            .append(".....").toString()

    }

}