package drawing.domain

import spock.lang.Specification

class LineSpec extends Specification {

    void 'returns line coordinates'() {
        given:
        def line = new Line(new Coordinate(0, 0), new Coordinate(0, 2))

        expect:
        line.coordinates == [
            new Coordinate(0, 0),
            new Coordinate(0, 1),
            new Coordinate(0, 2)
        ] as Set
    }
}
