package drawing.domain

import spock.lang.Specification

class CanvasSpec extends Specification {

    void 'returns if a canvas is empty'() {
        expect:
        new Canvas().isEmpty()
        new Canvas(1, 1).isEmpty() == false
    }

    void 'draws a point in a canvas'() {
        given:
        def canvas = new Canvas(1, 1)
        def line = new Line(new Coordinate(1, 1), new Coordinate(1, 1))

        when:
        def newCanvas = canvas.drawLine(line)

        then:
        newCanvas.matrix == [['X']]
    }

    void 'draws a line in a canvas'() {
        given:
        def canvas = new Canvas(5, 2)
        def line = new Line(new Coordinate(1, 1), new Coordinate(3, 1))

        when:
        def newCanvas = canvas.drawLine(line)

        then:
        newCanvas.matrix == [
            ['X', 'X', 'X', ' ', ' '],
            [' ', ' ', ' ', ' ', ' ']
        ]
    }

}
