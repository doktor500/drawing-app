package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line

class CreateLineCommand implements Command<Line> {

    Tuple<Integer> coordinate1
    Tuple<Integer> coordinate2

    @Override
    Line execute() {
        def origin = new Coordinate(x: coordinate1.first() - 1, y: coordinate1.last() - 1)
        def destination = new Coordinate(x: coordinate2.first() - 1, y: coordinate2.last() - 1)
        new Line(origin: origin, destination: destination)
    }
}
