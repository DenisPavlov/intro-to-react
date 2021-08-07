package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button

external interface SquareProps : RProps {
    var value: Int
}

class Square(props: SquareProps) : RComponent<SquareProps, RState>(props) {
    override fun RBuilder.render() {
        button(classes = "square") {
            +"${props.value}"
        }
    }
}