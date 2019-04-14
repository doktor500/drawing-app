package drawing

import drawing.application.commands.CreateCanvasCommand
import drawing.application.commands.CreateLineCommand
import drawing.application.commands.CreateRectangleCommand
import drawing.application.commands.CreateColourCommand
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static drawing.application.utils.StringUtils.format

@Stepwise
class DrawingAppFunctionalSpec extends Specification {

    @Shared app = new DrawingApp()

    void 'draws a canvas'() {
        given:
        def command = new CreateCanvasCommand(width: 20, height: 4)

        expect:
        app.process(command) == format("""
            ----------------------
            |                    |
            |                    |
            |                    |
            |                    |
            ----------------------
        """)
    }

    void 'draws a line'() {
        given:
        def coordinate1 = new Tuple(1, 2)
        def coordinate2 = new Tuple(6, 2)
        def command = new CreateLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        app.process(command) == format("""
            ----------------------
            |                    |
            |XXXXXX              |
            |                    |
            |                    |
            ----------------------
        """)
    }

    void 'draws multiple lines'() {
        given:
        def coordinate1 = new Tuple(6, 3)
        def coordinate2 = new Tuple(6, 4)
        def command = new CreateLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        app.process(command) == format("""
            ----------------------
            |                    |
            |XXXXXX              |
            |     X              |
            |     X              |
            ----------------------
        """)
    }

    void 'draws a rectangle'() {
        given:
        def coordinate1 = new Tuple(16, 1)
        def coordinate2 = new Tuple(20, 3)
        def command = new CreateRectangleCommand(coordinate1: coordinate1, coordinate2: coordinate2)

        expect:
        app.process(command) == format("""
            ----------------------
            |               XXXXX|
            |XXXXXX         X   X|
            |     X         XXXXX|
            |     X              |
            ----------------------
        """)
    }

    void 'fills with colour'() {
        given:
        def coordinate = new Tuple(10, 3)
        def colour = 'o'
        def command = new CreateColourCommand(coordinate: coordinate, colour: colour)

        expect:
        app.process(command) == format("""
            ----------------------
            |oooooooooooooooXXXXX|
            |XXXXXXoooooooooX   X|
            |     XoooooooooXXXXX|
            |     Xoooooooooooooo|
            ----------------------
        """)
    }
}
