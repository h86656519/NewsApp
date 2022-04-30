package net.pixnet.newsapp.Model


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("appearance")
    val appearance: AppearanceX,
    @SerializedName("extra")
    val extra: ExtraX,
    @SerializedName("_meta")
    val meta: Meta,
    @SerializedName("ref")
    val ref: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("type")
    val type: String
)