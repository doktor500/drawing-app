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
        def line = new Line(new Coordinate(0, 0), new Coordinate(0, 0))

        when:
        def newCanvas = canvas.drawLine(line)

        then:
        newCanvas.matrix == [['X']]
    }

    void 'draws a line in a canvas'() {
        given:
        def canvas = new Canvas(5, 2)
        def line = new Line(new Coordinate(0, 0), new Coordinate(2, 0))

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
            new Line(new Coordinate(15, 0), new Coordinate(15, 2)),
            new Line(new Coordinate(15, 0), new Coordinate(19, 0)),
            new Line(new Coordinate(19, 0), new Coordinate(19, 2)),
            new Line(new Coordinate(15, 2), new Coordinate(19, 2))
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

    void 'fills empty canvas with colour'() {
        given:
        def canvas = new Canvas(5, 3)
        def colour = new Colour(new Coordinate(3, 0), 'o')

        when:
        def newCanvas = canvas.fillWithColour(colour)

        then:
        newCanvas.matrix == [
            ['o', 'o', 'o', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o']
        ]
    }

}
