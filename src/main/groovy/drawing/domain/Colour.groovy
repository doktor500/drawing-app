package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Colour {
    Coordinate coordinate
    String value
}
