package app.presentation.draft.drafting

import app.presentation.draft.drafting.DraftingScreen
import core.mvvm.BaseViewModel
import core.mvvm.Intent
import core.mvvm.LoadingData
import core.mvvm.NavigationArgs
import kotlinx.coroutines.delay

class DraftingViewModel() : BaseViewModel() {
    private val args = NavigationArgs.getArgs<DraftingArgs>(DraftingScreen.ROUTE)

    override fun onCleared() {
        super.onCleared()
        NavigationArgs.removeArgs(DraftingScreen.ROUTE)
    }

    override fun obtainIntent(intent: Intent) {

    }

    init {
        launchCoroutine(needLoader = true) {
            delay(2000L)
            setState(DraftingViewState.DefaultState(args.someInt))
        }
    }
}