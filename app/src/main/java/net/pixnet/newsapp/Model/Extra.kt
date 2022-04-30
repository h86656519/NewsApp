package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class Extra(
    @SerializedName("created")
    val created: Long,
    @SerializedName("description")
    val description: String
)