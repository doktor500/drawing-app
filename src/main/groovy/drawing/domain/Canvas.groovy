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
        super()
    }

    Canvas(Integer width, Integer height) {
        this.width = width
        this.height = height
        this.matrix = isEmpty() ? EMPTY_MATRIX : initCanvas()
    }

    Canvas(Integer width, Integer height, List matrix) {
        this.width = width
        this.height = height
        this.matrix = matrix
    }

    Canvas drawLine(Line line) {
        new Canvas(width, height, createNewMatrix(line))
    }

    boolean isEmpty() {
        width == 0 && height == 0
    }

    private List createNewMatrix(Line line) {
        (1..height).collect { column ->
            (1..width).collect { row -> line.contains(new Coordinate(row, column)) ? NOT_EMPTY : SPACE }
        }
    }

    private List initCanvas() {
        (0..height - 1).collect {
            (0..width - 1).collect { SPACE }
        }
    }

}
