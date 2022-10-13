package juandahurt.payan.modules.feed.interfaces

import juandahurt.payan.modules.feed.models.FeedData

interface FeedRepository {
    suspend fun getData(): Result<FeedData?>
}