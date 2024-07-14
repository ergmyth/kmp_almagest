package app.presentation.live

import core.mvvm.BaseViewModel
import core.mvvm.Intent

class LiveViewModel() : BaseViewModel() {

    override fun obtainIntent(intent: Intent) {
        when (intent) {
            is LiveIntent.Open -> {
            }
        }
    }
}