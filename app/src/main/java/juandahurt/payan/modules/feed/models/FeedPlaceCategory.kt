package juandahurt.payan.modules.feed.models

import com.google.gson.annotations.SerializedName

data class FeedPlaceCategory(
    val title: String,
    val numberOfPlaces: Int,
    @SerializedName("image_url") val imageUrl: String
    )