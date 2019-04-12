package drawing.application

import drawing.domain.Canvas
import spock.lang.Specification

class CreateCanvasCommandSpec extends Specification {

    void 'creates a new canvas'() {
        given:
        def (width, height) = [0, 0]
        def command = new CreateCanvasCommand(width: width, height: height)

        expect:
        command.execute() == new Canvas(width, height)
    }
}
