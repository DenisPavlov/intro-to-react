package components

import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.attrs
import react.dom.button
import react.functionalComponent

external interface SquareProps : RProps {
    var value: String
    var onClickFunction: () -> Unit
}

val square = functionalComponent<SquareProps> { props ->
    button(classes = "square") {
        attrs {
            onClickFunction = { props.onClickFunction() }
        }
        +props.value
    }
}