package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class ExtraX(
    @SerializedName("created")
    val created: Int,
    @SerializedName("description")
    val description: String
)