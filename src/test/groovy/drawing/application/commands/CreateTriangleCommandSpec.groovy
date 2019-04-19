package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Triangle
import spock.lang.Specification

class CreateTriangleCommandSpec extends Specification {

    void 'creates a triangle'() {
        given:
        def coordinate1 = new Tuple(1, 1)
        def coordinate2 = new Tuple(6, 6)
        def coordinate3 = new Tuple(6, 1)
        def command = new CreateTriangleCommand(coordinate1, coordinate2, coordinate3)

        expect:
        command.execute() == new Triangle([
            new Line(Coordinate.fromTuple(coordinate1), Coordinate.fromTuple(coordinate2)),
            new Line(Coordinate.fromTuple(coordinate2), Coordinate.fromTuple(coordinate3)),
            new Line(Coordinate.fromTuple(coordinate3), Coordinate.fromTuple(coordinate1))
        ] as Set)
    }
    
}
