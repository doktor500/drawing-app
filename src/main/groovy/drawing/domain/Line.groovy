package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Line {

    Coordinate origin
    Coordinate destination

    Set getCoordinates() {
        (origin.x .. destination.x).collectMany { x->
            (origin.y .. destination.y).collect { y -> new Coordinate(x, y) }
        }
    }
}
