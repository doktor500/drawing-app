package drawing.application.commands

import drawing.domain.Canvas
import spock.lang.Specification

class DrawCanvasCommandSpec extends Specification {

    void 'creates a new canvas'() {
        given:
        def (width, height) = [0, 0]
        def command = new DrawCanvasCommand(width: width, height: height)

        expect:
        command.execute() == new Canvas(width, height)
    }
}
