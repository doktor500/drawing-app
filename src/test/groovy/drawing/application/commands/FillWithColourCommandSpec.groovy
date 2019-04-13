package drawing.application.commands

import drawing.domain.ColourPoint
import drawing.domain.Coordinate
import spock.lang.Specification

class FillWithColourCommandSpec extends Specification {

    void 'creates a new colour'() {
        given:
        def coordinate = new Tuple(1, 1)
        def colour = 'o'
        def expectedColourPoint = new ColourPoint(new Coordinate(0, 0), colour)

        expect:
        new FillWithColourCommand(coordinate: coordinate, colour: colour).execute() == expectedColourPoint
    }
}
