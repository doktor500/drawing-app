package drawing.domain

import spock.lang.Specification

class LineSpec extends Specification {

    void 'returns if line contains point'() {
        given:
        def line = new Line(new Coordinate(1, 1), new Coordinate(1, 3))

        expect:
        line.contains(new Coordinate(1, 1))
        line.contains(new Coordinate(1, 2))
        line.contains(new Coordinate(1, 3))

        line.contains(new Coordinate(1, 4)) == false
        line.contains(new Coordinate(2, 3)) == false
    }
}
