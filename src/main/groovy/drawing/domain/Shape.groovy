package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class Shape {
    Set<Line> lines
}
