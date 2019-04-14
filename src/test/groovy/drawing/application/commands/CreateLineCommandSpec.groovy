package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import spock.lang.Specification

class CreateLineCommandSpec extends Specification {

    void 'creates a new line'() {
        given:
        def coordinate1 = new Tuple(1, 2)
        def coordinate2 = new Tuple(6, 2)
        def command = new CreateLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        command.execute() == expectedLine

        where:
        expectedLine = new Line(new Coordinate(0, 1), new Coordinate(5, 1))
    }
}
