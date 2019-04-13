package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line

class DrawLineCommand implements Command<Line> {

    Tuple<Integer> coordinate1
    Tuple<Integer> coordinate2

    @Override
    Line execute() {
        def origin = new Coordinate(x: coordinate1.first(), y: coordinate1.last())
        def destination = new Coordinate(x: coordinate2.first(), y: coordinate2.last())
        new Line(origin: origin, destination: destination)
    }
}
