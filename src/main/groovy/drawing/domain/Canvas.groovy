package drawing.domain

import groovy.transform.EqualsAndHashCode

import static drawing.application.utils.Characters.*
import static drawing.application.utils.StringUtils.format

@EqualsAndHashCode
class Canvas {

    private static final EMPTY_MATRIX = [[]]

    private Integer width = 0
    private Integer height = 0

    private List matrix = EMPTY_MATRIX

    Canvas() {

    }

    Canvas(Integer width, Integer height) {
        this.width = width
        this.height = height
        this.matrix = isEmpty() ? EMPTY_MATRIX : initCanvas()
    }

    String toString() {
        isEmpty() ? EMPTY : format(printCanvas())
    }

    private isEmpty() {
        width == 0 && height == 0
    }

    // TODO Move to a presenter
    private printCanvas() {
        """
            ${printEdgeRow()}
            ${printMatrix()}
            ${printEdgeRow()}
        """
    }

    private initCanvas() {
        (0..width - 1).collect {
            (0..height - 1).collect { SPACE }
        }
    }

    private printMatrix() {
        (0..width - 1).collect { row -> printRow(row) }.join(NEW_LINE)
    }

    private printRow(Integer row) {
        PIPE + (0..height - 1).collect { column -> matrix[row][column] }.join() + PIPE
    }

    private printEdgeRow() {
        (0..width + 1).collect { SEPARATOR }.join()
    }

}
