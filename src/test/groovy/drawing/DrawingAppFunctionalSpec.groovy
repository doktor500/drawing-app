package drawing

import drawing.application.commands.DrawCanvasCommand
import drawing.application.commands.DrawLineCommand
import drawing.application.commands.DrawRectangleCommand
import drawing.infrastructure.Console
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static drawing.application.utils.StringUtils.format

@Stepwise
class DrawingAppFunctionalSpec extends Specification {

    Console console
    @Shared app = new DrawingApp()

    def setup() {
        app.console = console = Mock(Console)
    }

    void 'draws a canvas'() {
        given:
        def command = new DrawCanvasCommand(width: 20, height: 4)

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

    void 'draws a line'() {
        given:
        def coordinate1 = new Tuple(1, 2)
        def coordinate2 = new Tuple(6, 2)
        def command = new DrawLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        when:
        app.process(command)
        app.print()

        then:
        1 * console.print(format("""
            ----------------------
            |                    |
            |XXXXXX              |
            |                    |
            |                    |
            ----------------------
        """))
    }

    void 'draws multiple lines'() {
        given:
        def coordinate1 = new Tuple(6, 3)
        def coordinate2 = new Tuple(6, 4)
        def command = new DrawLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        when:
        app.process(command)
        app.print()

        then:
        1 * console.print(format("""
            ----------------------
            |                    |
            |XXXXXX              |
            |     X              |
            |     X              |
            ----------------------
        """))
    }

    void 'draws a rectangle'() {
        given:
        def coordinate1 = new Tuple(16, 1)
        def coordinate2 = new Tuple(20, 3)
        def command = new DrawRectangleCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        when:
        app.process(command)
        app.print()

        then:
        1 * console.print(format("""
            ----------------------
            |               XXXXX|
            |XXXXXX         X   X|
            |     X         XXXXX|
            |     X              |
            ----------------------
        """))
    }
}
