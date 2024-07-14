package app.presentation.draft

import core.mvvm.ViewState

sealed interface DraftViewState : ViewState {
    object InitialState: DraftViewState
}