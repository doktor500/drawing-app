package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Coordinate {

    Integer x
    Integer y

    Set<Coordinate> getNeighbors() {
        [(x - 1..x + 1), (y - 1..y + 1)].combinations().collect { x, y -> new Coordinate(x, y) } - this
    }

    String toString() {
        "($x, $y)"
    }
}
