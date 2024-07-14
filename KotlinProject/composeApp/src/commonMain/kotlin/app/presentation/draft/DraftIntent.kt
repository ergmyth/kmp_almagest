package app.presentation.draft

import core.mvvm.Intent

sealed interface DraftIntent : Intent {
    object OpenDrafting : DraftIntent
}