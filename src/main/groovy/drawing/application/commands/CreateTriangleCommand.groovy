package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Triangle
import groovy.transform.TupleConstructor

@TupleConstructor
class CreateTriangleCommand implements Command<Triangle> {

    Tuple<Integer> coordinate1
    Tuple<Integer> coordinate2
    Tuple<Integer> coordinate3

    Triangle execute() {
        new Triangle([
            new Line(Coordinate.fromTuple(coordinate1), Coordinate.fromTuple(coordinate2)),
            new Line(Coordinate.fromTuple(coordinate2), Coordinate.fromTuple(coordinate3)),
            new Line(Coordinate.fromTuple(coordinate3), Coordinate.fromTuple(coordinate1))
        ] as Set)
    }
}
