package app.presentation.draft.drafting

import app.presentation.draft.DraftViewState
import core.mvvm.ViewState


sealed interface DraftingViewState: ViewState {
    class DefaultState(val someInt: Int) : DraftingViewState
}