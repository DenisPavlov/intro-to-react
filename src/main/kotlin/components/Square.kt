package components

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.attrs
import react.dom.button

external interface SquareProps : RProps {
    var value: String
    var onClickFunction: () -> Unit
}

data class SquareState(val value: String) : RState

class Square(props: SquareProps) : RComponent<SquareProps, SquareState>(props) {
    override fun RBuilder.render() {
        button(classes = "square") {
            attrs {
                onClickFunction = { props.onClickFunction() }
            }
            +props.value
        }
    }
}