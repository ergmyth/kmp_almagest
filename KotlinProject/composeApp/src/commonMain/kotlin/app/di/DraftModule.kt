package app.di

import app.presentation.draft.DraftViewModel
import app.presentation.draft.drafting.DraftingViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDraftModule(): Module {
    return module {
        factory { DraftViewModel() }
        factory { DraftingViewModel() }
    }
}