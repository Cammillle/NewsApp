package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.models.Article
import com.example.newsapp.repository.NewsRepository

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsArticleViewHolder>() {

    lateinit var articleImage:ImageView
    lateinit var articleSource:TextView
    lateinit var articleTitle:TextView
    lateinit var articleDescription:TextView
    lateinit var articleDateTime:TextView

    inner class NewsArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)?=null

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {

    }
}