package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.ol

class Game(props: RProps): RComponent<RProps, RState>(props) {
    override fun RBuilder.render() {
        div(classes = "game") {
            div(classes = "game-board") {
                child(Board::class) { }
            }
            div(classes = "game-info") {
                div {  }
                ol {  }
            }
        }
    }
}