package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class AppearanceX(
    @SerializedName("mainTitle")
    val mainTitle: String,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("subscript")
    val subscript: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)