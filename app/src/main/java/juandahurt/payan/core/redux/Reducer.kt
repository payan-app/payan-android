package juandahurt.payan.core.redux

interface Reducer<S: State, A: Action> {
    fun reduce(currentState: S, action: A): S
}