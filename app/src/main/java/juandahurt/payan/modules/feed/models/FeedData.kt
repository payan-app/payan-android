package juandahurt.payan.modules.feed.models

import com.google.gson.annotations.SerializedName

data class FeedData(
    @SerializedName("placeCategories") var placeCategories: List<FeedPlaceCategory>
)