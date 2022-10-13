package juandahurt.payan.modules.feed.data

import juandahurt.payan.core.network.NetworkManager
import juandahurt.payan.modules.feed.interfaces.FeedRepository
import juandahurt.payan.modules.feed.interfaces.FeedService
import juandahurt.payan.modules.feed.models.FeedData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedDataRemoteDataRepository(
    private val feedService: FeedService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): FeedRepository {
    override suspend fun getData(): Result<FeedData?> = makeApiCall(dispatcher) {
        feedService.getData("feed").body()?.data
    }
}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}