package app.presentation.live

import core.mvvm.Intent

sealed interface LiveIntent : Intent {
    object Open : LiveIntent
}