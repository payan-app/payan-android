package juandahurt.payan.modules.feed

import androidx.compose.runtime.Composable
import juandahurt.payan.core.network.NetworkManager
import juandahurt.payan.modules.feed.data.FeedDataRemoteDataRepository
import juandahurt.payan.modules.feed.interfaces.FeedService
import juandahurt.payan.modules.feed.ui.FeedPageView
import juandahurt.payan.modules.feed.ui.FeedViewModel

class FeedBuilder {
    private val viewModel = FeedViewModel(
        repository = FeedDataRemoteDataRepository(
            feedService = NetworkManager
                .getSharedInstance()
                .getRetrofitInstance()
                .create(FeedService::class.java)
        )
    )

    @Composable
    fun Build() {
        FeedPageView(viewModel = viewModel)
    }
}