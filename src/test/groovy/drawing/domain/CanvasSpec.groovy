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

    void 'draws a rectangle in a canvas'() {
        given:
        def canvas = new Canvas(20, 4)
        def rectangle = new Rectangle([
            new Line(new Coordinate(16, 1), new Coordinate(16, 3)),
            new Line(new Coordinate(16, 1), new Coordinate(20, 1)),
            new Line(new Coordinate(20, 1), new Coordinate(20, 3)),
            new Line(new Coordinate(16, 3), new Coordinate(20, 3))
        ] as Set)

        when:
        def newCanvas = canvas.drawRectangle(rectangle)

        then:
        newCanvas.matrix == [
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
        ]
    }

}
