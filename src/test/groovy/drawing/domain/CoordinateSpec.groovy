package drawing.domain

import spock.lang.Specification

class CoordinateSpec extends Specification {

    void 'returns neighbors'() {
        given:

        def coordinate = new Coordinate(1, 1)

        expect:
        coordinate.neighbors == [
            new Coordinate(0, 0),
            new Coordinate(1, 0),
            new Coordinate(2, 0),
            new Coordinate(0, 1),
            new Coordinate(2, 1),
            new Coordinate(0, 2),
            new Coordinate(1, 2),
            new Coordinate(2, 2)
        ] as Set
    }

    void 'creates a coordinate from a tuple of integers'() {
        expect:
        Coordinate.fromTuple(new Tuple(1, 1)) == new Coordinate(1, 1)
    }
}
