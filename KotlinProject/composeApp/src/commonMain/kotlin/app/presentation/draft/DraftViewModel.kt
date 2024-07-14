package app.presentation.draft

import app.presentation.draft.drafting.DraftingArgs
import app.presentation.draft.drafting.DraftingScreen
import core.mvvm.Args
import core.mvvm.BaseViewModel
import core.mvvm.Intent
import core.mvvm.ViewEvent
import core.navigation.navigateViaRoute

class DraftViewModel() : BaseViewModel() {


    override fun obtainIntent(intent: Intent) {
        when (intent) {
            is DraftIntent.OpenDrafting -> {
                val screen = DraftingScreen(DraftingArgs(5))
                emitEvent(ViewEvent.Navigation(screen))
            }
        }
    }
}