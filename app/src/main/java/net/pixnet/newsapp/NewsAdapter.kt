package net.pixnet.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import net.pixnet.newsapp.Model.Item
import net.pixnet.newsapp.databinding.DividerItemLayoutBinding
import net.pixnet.newsapp.databinding.NewsItemLayoutBinding
import java.time.Instant
import java.time.ZoneId


class NewsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemsList = listOf<Item>()
    private val dividerViewType = 0   //divider
    private val newsViewType = 1 //new

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dividerBinding = DividerItemLayoutBinding.inflate(layoutInflater, parent, false)
        val newsBinding = NewsItemLayoutBinding.inflate(layoutInflater, parent, false)

        return when (viewType) {
            dividerViewType -> DividerViewHolder(dividerBinding)
            newsViewType -> NewsViewHolder(newsBinding)
            else -> NewsViewHolder(newsBinding)
        }
    }


    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return when (itemsList[position].type) {
            "divider" -> dividerViewType
            "news" -> newsViewType
            else -> {
                newsViewType
            }
        }
    }

    override fun getItemCount() = itemsList.size - 1

    fun updateList(list: List<Item>) {
        itemsList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            dividerViewType -> {
                val holder = holder as DividerViewHolder
                holder.updateDivider()
            }

            newsViewType -> {
                val holder = holder as NewsViewHolder
                holder.updateNewsItem()
            }
        }
    }

    inner class DividerViewHolder(private val binding: DividerItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun updateDivider() {
            binding.tvDivider.text = itemsList[adapterPosition].title
        }

    }

    inner class NewsViewHolder(private val binding: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun updateNewsItem() {
            println("adapterPosition: $adapterPosition")
            binding.tvCreate.text = convertTimestamp(itemsList[adapterPosition].extra?.created)
            binding.tvMainTitle.text = itemsList[adapterPosition].appearance.mainTitle
            binding.tvSubTitle.text = itemsList[adapterPosition].appearance.subTitle
            binding.tvSubscript.text = itemsList[adapterPosition].appearance.subscript
            binding.ivThumbnail.load(itemsList[adapterPosition].appearance.thumbnail)
        }

    }

    fun convertTimestamp(timeStamp: Long?): String {
        if (timeStamp == null) return ""
        val dt = Instant.ofEpochSecond(timeStamp)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
        println("dt $dt")
        return dt.toString()

    }
}