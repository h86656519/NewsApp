package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class NewRespondModel(
    @SerializedName("getVector")
    val getVector: GetVector
)