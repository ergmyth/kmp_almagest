package core.mvvm

interface ViewState
interface Intent
interface ViewEvent {
    class Navigation(val screen: Screen) : ViewEvent
    class PopBackStack(val result: Result) : ViewEvent
}

