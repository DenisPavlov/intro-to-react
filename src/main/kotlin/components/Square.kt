package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button

class Square(props: RProps): RComponent<RProps, RState>(props) {
    override fun RBuilder.render() {
        button(classes = "square") {
            // TODO("Not yet implemented")
        }
    }
}