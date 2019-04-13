package drawing

import drawing.application.commands.CreateCanvasCommand
import drawing.infrastructure.Console
import spock.lang.Specification

import static drawing.application.utils.StringUtils.format

class DrawingAppSpec extends Specification {

    void 'draws a canvas'() {
        given:
        def console = Mock(Console)
        def app = new DrawingApp(console: console)
        def command = new CreateCanvasCommand(width: 20, height: 4)

        when:
        app.process(command)
        app.print()

        then:
        1 * console.print(format("""
            ----------------------
            |                    |
            |                    |
            |                    |
            |                    |
            ----------------------
        """))
    }
}
