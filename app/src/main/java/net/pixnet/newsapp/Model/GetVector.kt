package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class GetVector(
    @SerializedName("items")
    val items: List<Item>
)