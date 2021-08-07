package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

data class BoardState(val squares: MutableList<String>) : RState

class Board(props: RProps): RComponent<RProps, BoardState>(props) {
    private val status = "Next player: X"

    init {
        state = BoardState(
            squares = MutableList(9) { "" }
        )
    }

    private fun RBuilder.renderSquare(i: Int) {
        child(Square::class){
            attrs.value = state.squares[i]
        }
    }

    override fun RBuilder.render() {
        div {
            div(classes = "status") { +status }
            div(classes = "board-row") {
                renderSquare(0)
                renderSquare(1)
                renderSquare(2)
            }
            div(classes = "board-row") {
                renderSquare(3)
                renderSquare(4)
                renderSquare(5)
            }
            div(classes = "board-row") {
                renderSquare(6)
                renderSquare(7)
                renderSquare(8)
            }
        }
    }
}