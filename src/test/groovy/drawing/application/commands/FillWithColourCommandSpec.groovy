package drawing.application.commands

import drawing.domain.Colour
import drawing.domain.Coordinate
import spock.lang.Specification

class FillWithColourCommandSpec extends Specification {

    void 'creates a new colour'() {
        given:
        def coordinate = new Tuple(1, 1)
        def colour = 'o'
        def expectedColour = new Colour(new Coordinate(1, 1), colour)

        expect:
        new FillWithColourCommand(coordinate: coordinate, colour: colour).execute() == expectedColour
    }
}
