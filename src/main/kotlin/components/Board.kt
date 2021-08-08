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
        if (calculateWinner(squares) != "" || squares[i] != "") {
            return
        }
        squares[i] = if (state.xIsNext) "X" else "O"
        setState(
            BoardState(
                squares = squares.toList(),
                xIsNext = !state.xIsNext,
            )
        )
    }

    override fun RBuilder.render() {
        val winner = calculateWinner(state.squares)
        val status = if (winner != "") {
            "Winner: $winner"
        } else {
            "Next player: ${if (state.xIsNext) "X" else "O"}"
        }

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

    private fun calculateWinner(squares: List<String>): String {
        val lines = listOf(
            Triple(0, 1, 2),
            Triple(3, 4, 5),
            Triple(6, 7, 8),
            Triple(0, 3, 6),
            Triple(1, 4, 7),
            Triple(2, 5, 8),
            Triple(0, 4, 8),
            Triple(2, 4, 6),
        )

        lines.forEach { line ->
            val (a, b, c) = line
            if (squares[a] != "" && squares[a] == squares[b] && squares[a] == squares[c]) {
                return squares[a]
            }
        }
        return ""
    }
}