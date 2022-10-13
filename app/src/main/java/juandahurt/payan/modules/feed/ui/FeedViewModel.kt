package juandahurt.payan.modules.feed.ui

import androidx.lifecycle.viewModelScope
import juandahurt.payan.core.ui.BaseViewModel
import juandahurt.payan.modules.feed.interfaces.FeedRepository
import juandahurt.payan.modules.feed.models.FeedContract
import kotlinx.coroutines.launch

class FeedViewModel(
    val repository: FeedRepository
): BaseViewModel<FeedContract.Event, FeedContract.State>() {
    init {
        getDataWrapper()
    }

    override fun setInitialState() = FeedContract.State(
        true,
        null
    )

    override fun handleEvents(event: FeedContract.Event) {
        TODO("Not yet implemented")
    }

    private fun getDataWrapper() {
        viewModelScope.launch {
            getData()
        }
    }

    suspend fun getData() {
        repository.getData()
            .onSuccess { data ->
                setState {
                    copy(isLoading = false, data = data)
                }
            }
    }
}