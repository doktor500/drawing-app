package drawing.application.commands

import drawing.domain.Coordinate
import drawing.domain.Line
import spock.lang.Specification

class DrawLineCommandSpec extends Specification {

    private static final ORIGIN_X = 1
    private static final ORIGIN_Y = 2

    private static final DESTINATION_X = 6
    private static final DESTINATION_Y = 2

    void 'creates a new line'() {
        given:
        def coordinate1 = new Tuple(ORIGIN_X, ORIGIN_Y)
        def coordinate2 = new Tuple(DESTINATION_X, DESTINATION_Y)
        def command = new DrawLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        command.execute() == expectedLine

        where:
        expectedLine = new Line(new Coordinate(ORIGIN_X, ORIGIN_Y), new Coordinate(DESTINATION_X, DESTINATION_Y))
    }
}
