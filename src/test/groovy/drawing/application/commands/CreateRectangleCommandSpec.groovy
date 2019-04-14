package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Rectangle
import spock.lang.Specification

class CreateRectangleCommandSpec extends Specification {

    void 'creates a new rectangle'() {
        given:
        def coordinate1 = new Tuple(16, 1)
        def coordinate2 = new Tuple(20, 3)
        def command = new CreateRectangleCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        command.execute() == expectedRectangle

        where:
        expectedRectangle = new Rectangle([
            new Line(new Coordinate(15, 0), new Coordinate(15, 2)),
            new Line(new Coordinate(15, 0), new Coordinate(19, 0)),
            new Line(new Coordinate(19, 0), new Coordinate(19, 2)),
            new Line(new Coordinate(15, 2), new Coordinate(19, 2))
        ] as Set)
    }
}
