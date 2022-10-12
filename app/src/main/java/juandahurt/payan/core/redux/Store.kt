package juandahurt.payan.core.redux

class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<S, A>
) {
    var state = initialState

    fun dispatch(action: A) {
        state = reducer.reduce(state, action)
    }
}