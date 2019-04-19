package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Line {

    Coordinate origin
    Coordinate destination

    Set<Coordinate> getCoordinates() {
        isStraight() ? this.straightLineCoordinates : this.diagonalLineCoordinates
    }

    private boolean isStraight() {
        origin.x == destination.x || origin.y == destination.y
    }

    private Set<Coordinate> getDiagonalLineCoordinates() {
        [
            (origin.x .. destination.x).toList(),
            (origin.y .. destination.y).toList(),
        ].transpose().collect { new Coordinate(it.first(), it.last()) }
    }

    private Set<Coordinate> getStraightLineCoordinates() {
        (origin.x .. destination.x).collectMany { x->
            (origin.y .. destination.y).collect { y -> new Coordinate(x, y) }
        }
    }
}
