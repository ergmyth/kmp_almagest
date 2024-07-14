package app.presentation.draft.drafting

import app.presentation.draft.drafting.DraftingScreen
import core.mvvm.BaseViewModel
import core.mvvm.Intent
import core.mvvm.NavigationArgs

class DraftingViewModel() : BaseViewModel() {
    private val args = NavigationArgs.getArgs<DraftingArgs>(DraftingScreen.ROUTE)

    override fun obtainIntent(intent: Intent) {

    }

    init {
        setState(DraftingViewState.DefaultState(args.someInt))
    }
}