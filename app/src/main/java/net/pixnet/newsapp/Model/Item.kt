package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("appearance")
    val appearance: Appearance,
    @SerializedName("extra")
    val extra: Extra?,
    @SerializedName("items")
    val items: List<ItemX>,
    @SerializedName("_meta")
    val meta: MetaX,
    @SerializedName("ref")
    val ref: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("style")
    val style: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)