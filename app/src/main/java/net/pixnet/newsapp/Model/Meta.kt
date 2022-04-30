package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("category")
    val category: List<String>,
    @SerializedName("section")
    val section: String
)