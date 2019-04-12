package drawing.domain

import spock.lang.Specification

import static drawing.application.utils.StringUtils.format

class CanvasSpec extends Specification {

    void 'converts an empty canvas to string format'() {
        expect:
        new Canvas().toString() == ''
    }

    void 'converts a small canvas to string format'() {
        given:
        def expectedCanvas = """
            ---
            | |
            ---
        """
        expect:
        new Canvas(1, 1).toString() == format(expectedCanvas)
    }

    void 'converts a canvas to string format'() {
        given:
        def expectedCanvas = """
            -----
            |   |
            |   |
            |   |
            -----
        """
        expect:
        new Canvas(3, 3).toString() == format(expectedCanvas)
    }
}
