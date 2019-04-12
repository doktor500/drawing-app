package drawing

import drawing.application.CreateCanvasCommand
import drawing.infrastructure.Console
import spock.lang.Specification

class DrawingAppSpec extends Specification {

    void 'creates an empty canvas'() {
        given:
        def console = Mock(Console)
        def app = new DrawingApp(console: console)
        def command = new CreateCanvasCommand(width: width, height: height)

        when:
        app.process(command)

        then:
        1 * console.print('')

        where:
        width | height
        0     | 0
    }
}
