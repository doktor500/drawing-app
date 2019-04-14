package drawing.application.commands

import drawing.domain.ColourPoint
import drawing.domain.Coordinate
import spock.lang.Specification

class AddColourCommandSpec extends Specification {

    void 'creates an instance of an add colour command'() {
        given:
        def coordinate = new Tuple(1, 1)
        def colour = 'o'
        def expectedColourPoint = new ColourPoint(new Coordinate(0, 0), colour)

        expect:
        new AddColourCommand(coordinate: coordinate, colour: colour).execute() == expectedColourPoint
    }
}
