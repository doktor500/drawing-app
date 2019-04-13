package drawing.application.presenters

import drawing.domain.Canvas
import spock.lang.Specification

import static drawing.application.utils.StringUtils.format

class CanvasPresenterSpec extends Specification {

    void 'converts an empty canvas to string format'() {
        given:
        def canvas = new Canvas() as CanvasPresenter

        expect:
        canvas.present() == ''
    }

    void 'converts a small canvas to string format'() {
        given:
        def canvas = new Canvas(1, 1) as CanvasPresenter

        def expectedCanvas = """
            ---
            | |
            ---
        """

        expect:
        canvas.present() == format(expectedCanvas)
    }

    void 'converts a canvas to string format'() {
        given:
        def canvas = new Canvas(3, 3) as CanvasPresenter

        def expectedCanvas = """
            -----
            |   |
            |   |
            |   |
            -----
        """

        expect:
        canvas.present() == format(expectedCanvas)
    }
}
