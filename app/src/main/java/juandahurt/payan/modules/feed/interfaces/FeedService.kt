package juandahurt.payan.modules.feed.interfaces

import juandahurt.payan.core.network.ServerResponse
import juandahurt.payan.modules.feed.models.FeedData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FeedService {
    @GET
    suspend fun getData(@Url url: String): Response<ServerResponse<FeedData>>
}