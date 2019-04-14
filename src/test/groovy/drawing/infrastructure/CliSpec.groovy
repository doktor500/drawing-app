package drawing.infrastructure

import drawing.DrawingApp
import drawing.application.commands.DrawCanvasCommand
import drawing.application.commands.DrawLineCommand
import drawing.application.commands.DrawRectangleCommand
import drawing.application.commands.FillWithColourCommand
import picocli.CommandLine
import spock.lang.Specification
import spock.lang.Unroll

import static drawing.infrastructure.Cli.CliCommand
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals

class CliSpec extends Specification {

    @Unroll
    void 'can process commands'() {
        given:
        def app = Mock(DrawingApp)
        Cli.app = app

        when:
        CommandLine.run(new CliCommand(), input.split())

        then:
        1 * app.process({ assertEquals(it, command) })

        where:
        input         | command
        'C 20 4'      | new DrawCanvasCommand(width: 20, height: 4)
        'L 1 2 6 2'   | new DrawLineCommand(coordinate1: new Tuple(1, 2), coordinate2: new Tuple(6, 2))
        'R 16 1 20 3' | new DrawRectangleCommand(coordinate1: new Tuple(16, 1), coordinate2: new Tuple(20, 3))
        'B 10 3 o'    | new FillWithColourCommand(coordinate: new Tuple(10, 3), colour: 'o')
    }

    private boolean assertEquals(actual, expected) {
        assertReflectionEquals(expected, actual)
        true
    }
}
