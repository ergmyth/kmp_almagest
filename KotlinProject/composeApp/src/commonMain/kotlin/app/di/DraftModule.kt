package app.di

import app.presentation.draft.DraftViewModel
import app.presentation.draft.drafting.DraftingViewModel
import app.presentation.live.LiveViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDraftModule(): Module {
    return module {
        factory { DraftViewModel() }
        factory { DraftingViewModel() }
    }
}
fun getLiveModule(): Module {
    return module {
        factory { LiveViewModel() }
    }
}