package core.mvvm

abstract class Screen(
    val route: String,
    args: Args? = null
) {
    init {
        if (args != null) NavigationArgs.putArgs(args, route)
    }
}

interface Args
interface Result

object NavigationArgs {
    private val argsMap: MutableMap<String, Args> = mutableMapOf()
    val resultMap: MutableMap<String, Result> = mutableMapOf()

    fun <T : Args> getArgs(key: String): T {
        return requireNotNull(argsMap[key] as T)
    }
    //todo removing

    fun putArgs(args: Args, key: String) {
        argsMap[key] = args
    }
}