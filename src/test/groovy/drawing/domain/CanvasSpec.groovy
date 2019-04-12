package drawing.domain

import spock.lang.Specification

class CanvasSpec extends Specification {

    void 'converts a canvas to string format'() {
        expect:
        new Canvas().toString() == ''
    }
}
