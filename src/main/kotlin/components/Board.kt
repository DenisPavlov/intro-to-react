package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.child
import react.dom.div

data class BoardState(val squares: List<String>) : RState

class Board(props: RProps) : RComponent<RProps, BoardState>(props) {
    private val status = "Next player: X"

    init {
        state = BoardState(
            squares = List(9) { "" }
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
        squares[i] = "X"
        setState(BoardState(squares.toList()))
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