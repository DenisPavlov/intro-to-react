package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.child
import react.dom.div

data class BoardState(
    val squares: List<String>,
    val xIsNext: Boolean,
) : RState

class Board(props: RProps) : RComponent<RProps, BoardState>(props) {
    init {
        state = BoardState(
            squares = List(9) { "" },
            xIsNext = true,
        )
    }

    private fun RBuilder.renderSquare(i: Int) {
        child(square) {
            attrs.value = state.squares[i]
            attrs.onClickFunction = { handleClick(i) }
        }
    }

    private fun handleClick(i: Int) {
        val squares = state.squares.toMutableList()
        squares[i] = if (state.xIsNext) "X" else "O"
        setState(
            BoardState(
                squares = squares.toList(),
                xIsNext = !state.xIsNext,
            )
        )
    }

    override fun RBuilder.render() {
        val status = "Next player: ${if (state.xIsNext) "X" else "O"}"

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