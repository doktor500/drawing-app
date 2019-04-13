package drawing

import drawing.application.commands.CreateCanvasCommand
import drawing.infrastructure.Console
import spock.lang.Specification

class DrawingAppSpec extends Specification {

    void 'draws an empty canvas'() {
        given:
        def console = Mock(Console)
        def app = new DrawingApp(console: console)
        def command = new CreateCanvasCommand(width: 0, height: 0)

        when:
        app.process(command)
        app.print()

        then:
        1 * console.print('')
    }
}
