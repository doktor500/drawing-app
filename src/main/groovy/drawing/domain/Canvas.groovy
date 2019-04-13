package drawing.domain

import groovy.transform.EqualsAndHashCode

import static Characters.*

@EqualsAndHashCode
class Canvas {

    private static final List EMPTY_MATRIX = [[]]

    Integer width = 0
    Integer height = 0
    List matrix = EMPTY_MATRIX

    Canvas() {

    }

    Canvas(Integer width, Integer height) {
        this.width = width
        this.height = height
        this.matrix = isEmpty() ? EMPTY_MATRIX : initCanvas()
    }

    boolean isEmpty() {
        width == 0 && height == 0
    }

    private initCanvas() {
        (0..width - 1).collect {
            (0..height - 1).collect { SPACE }
        }
    }

}
