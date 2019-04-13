package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Line {

    Coordinate origin
    Coordinate destination

    boolean contains(Coordinate coordinate) {
        coordinate.x in (origin.x..destination.x) && coordinate.y in (origin.y..destination.y)
    }
}
