package app.presentation.live

import core.mvvm.ViewState

sealed interface LiveViewState : ViewState {
    object InitialState: LiveViewState
}