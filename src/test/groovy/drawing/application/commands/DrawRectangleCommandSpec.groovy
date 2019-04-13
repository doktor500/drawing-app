package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import drawing.domain.Rectangle
import spock.lang.Specification

class DrawRectangleCommandSpec extends Specification {

    void 'creates a new rectangle'() {
        given:
        def coordinate1 = new Tuple(16, 1)
        def coordinate2 = new Tuple(20, 3)
        def command = new DrawRectangleCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        command.execute() == expectedRectangle

        where:
        expectedRectangle = new Rectangle([
            new Line(new Coordinate(16, 1), new Coordinate(16, 3)),
            new Line(new Coordinate(16, 1), new Coordinate(20, 1)),
            new Line(new Coordinate(20, 1), new Coordinate(20, 3)),
            new Line(new Coordinate(16, 3), new Coordinate(20, 3))
        ] as Set)
    }
}
