package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Rectangle

class DrawRectangleCommand implements Command<Rectangle> {

    Tuple<Integer> coordinate1
    Tuple<Integer> coordinate2

    @Override
    Rectangle execute() {
        def origin = new Coordinate(x: coordinate1.first(), y: coordinate1.last())
        def destination = new Coordinate(x: coordinate2.first(), y: coordinate2.last())
        def lines = (1..4).collect { "line${it}"(origin, destination) } as Set
        new Rectangle(lines)
    }

    private Line line1(Coordinate origin, Coordinate destination) {
        new Line(origin, new Coordinate(coordinate1.first(), destination.y))
    }

    private Line line2(Coordinate origin, Coordinate destination) {
        new Line(origin, new Coordinate(destination.x, coordinate1.last()))
    }

    private Line line3(Coordinate origin, Coordinate destination) {
        new Line(new Coordinate(coordinate2.first(), origin.y), destination)
    }

    private Line line4(Coordinate origin, Coordinate destination) {
        new Line(new Coordinate(origin.x, coordinate2.last()), destination)
    }
}