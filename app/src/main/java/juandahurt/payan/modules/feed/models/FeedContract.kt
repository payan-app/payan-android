package juandahurt.payan.modules.feed.models

import juandahurt.payan.core.ui.ViewEvent
import juandahurt.payan.core.ui.ViewState

class FeedContract {
    sealed class Event: ViewEvent {
        object getData: Event()
    }

    data class State (
        val isLoading: Boolean,
        val data: FeedData?
    ): ViewState
}