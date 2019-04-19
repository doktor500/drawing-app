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
        def newCanvas = canvas.draw(line)

        then:
        newCanvas.matrix == [['X']]
    }

    void 'draws a line in a canvas'() {
        given:
        def canvas = new Canvas(5, 2)
        def line = new Line(new Coordinate(0, 0), new Coordinate(2, 0))

        when:
        def newCanvas = canvas.draw(line)

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
        def newCanvas = canvas.draw(rectangle)

        then:
        newCanvas.matrix == [
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X'],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
        ]
    }
    
    void 'draws a triangle in a canvas'() {
        given:
        def canvas = new Canvas(20, 8)
        def coordinate1 = new Tuple(1, 1)
        def coordinate2 = new Tuple(6, 6)
        def coordinate3 = new Tuple(1, 6)
        def triangle = new Triangle([
            new Line(Coordinate.fromTuple(coordinate1), Coordinate.fromTuple(coordinate2)),
            new Line(Coordinate.fromTuple(coordinate2), Coordinate.fromTuple(coordinate3)),
            new Line(Coordinate.fromTuple(coordinate3), Coordinate.fromTuple(coordinate1))
        ] as Set)

        when:
        def newCanvas = canvas.draw(triangle)

        then:
        newCanvas.matrix == [
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
            [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
        ]
    }

    void 'fills empty canvas with colour'() {
        given:
        def canvas = new Canvas(5, 3)
        def coordinate = new Coordinate(0, 0)
        def colour = 'o'

        when:
        def newCanvas = canvas.fill(coordinate, colour)

        then:
        newCanvas.matrix == [
            ['o', 'o', 'o', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o']
        ]
    }

    void 'fills canvas that contains a line with colour'() {
        def canvas = new Canvas(5, 3)
        def line = new Line(new Coordinate(0, 0), new Coordinate(2, 0))
        def coordinate = new Coordinate(3, 1)
        def colour = 'o'

        when:
        def newCanvas = canvas.draw(line).fill(coordinate, colour)

        then:
        newCanvas.matrix == [
            ['X', 'X', 'X', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o'],
            ['o', 'o', 'o', 'o', 'o']
        ]
    }
}
