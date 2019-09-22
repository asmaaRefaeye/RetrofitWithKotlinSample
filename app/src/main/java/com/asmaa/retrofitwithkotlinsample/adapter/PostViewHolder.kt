package com.asmaa.retrofitwithkotlinsample.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.posts_layout.view.*

class PostViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
{
    val text_author = itemView.text_author

    val text_content = itemView.text_content

    val text_title = itemView.text_title

}