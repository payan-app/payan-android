package juandahurt.payan.core.network

import com.google.gson.annotations.SerializedName

data class ServerResponse<T>(
    @SerializedName("success") var success: Boolean,
    @SerializedName("data") var data: T?
)