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

    Canvas drawRectangle(Rectangle rectangle) {
        rectangle.lines.inject(this) { canvas, line -> canvas.drawLine(line) }
    }

    Canvas fillWithColour(Colour colour) {
        new Canvas(width, height, initCanvas(colour.value))
    }

    boolean isEmpty() {
        width == 0 && height == 0
    }

    private List createNewMatrix(Line line) {
        (0..height - 1).collect { row ->
            (0..width - 1).collect { column -> line.contains(toCoordinate(row, column)) ? CROSS : matrix[row][column] }
        }
    }

    private List initCanvas(String value = SPACE) {
        (0..height - 1).collect {
            (0..width - 1).collect { value }
        }
    }

    private Coordinate toCoordinate(Integer row, Integer column) {
        new Coordinate(column, row)
    }

}
