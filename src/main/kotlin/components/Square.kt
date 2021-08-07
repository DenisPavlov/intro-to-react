package components

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.attrs
import react.dom.button

external interface SquareProps : RProps {
    var value: Int
}

data class SquareState(val value: String) : RState

class Square(props: SquareProps) : RComponent<SquareProps, SquareState>(props) {
    init {
        this.state = SquareState(props.value.toString())
    }

    override fun RBuilder.render() {
        button(classes = "square") {
            attrs {
                onClickFunction = { setState(SquareState("X")) }
            }
            +state.value
        }
    }
}