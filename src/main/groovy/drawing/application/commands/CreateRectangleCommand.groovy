package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Shape

class CreateRectangleCommand implements Command<Shape> {

    Tuple<Integer> coordinate1
    Tuple<Integer> coordinate2

    @Override
    Shape execute() {
        def origin = new Coordinate(x: coordinate1.first() - 1, y: coordinate1.last() - 1)
        def destination = new Coordinate(x: coordinate2.first() - 1, y: coordinate2.last() - 1)
        def lines = (1..4).collect { "line${it}"(origin, destination) } as Set
        new Shape(lines)
    }

    private Line line1(Coordinate origin, Coordinate destination) {
        new Line(origin, new Coordinate(coordinate1.first() - 1, destination.y))
    }

    private Line line2(Coordinate origin, Coordinate destination) {
        new Line(origin, new Coordinate(destination.x, coordinate1.last() - 1))
    }

    private Line line3(Coordinate origin, Coordinate destination) {
        new Line(new Coordinate(coordinate2.first() - 1, origin.y), destination)
    }

    private Line line4(Coordinate origin, Coordinate destination) {
        new Line(new Coordinate(origin.x, coordinate2.last() - 1), destination)
    }
}
