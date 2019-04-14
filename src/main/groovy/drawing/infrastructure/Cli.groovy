package drawing.infrastructure

import drawing.DrawingApp
import drawing.application.commands.CreateCanvasCommand
import drawing.application.commands.CreateLineCommand
import drawing.application.commands.CreateRectangleCommand
import drawing.application.commands.CreateColourCommand
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

class Cli {

    private static final PROMPT_MESSAGE = 'enter command: '
    static app = new DrawingApp()

    static void main(String... args) {
        def scanner = new Scanner(System.in)
        while (true) {
            println(PROMPT_MESSAGE)
            CommandLine.run(new CliCommand(), scanner.nextLine().split())
        }
    }

    @Command(name = '', subcommands = [DrawCanvas, DrawLine, DrawRectangle, Fill, Quit])
    static class CliCommand implements Runnable {
        void run() {
            println('Drawing App')
        }
    }

    @Command(name = 'C', description = 'Draw a canvas')
    static class DrawCanvas implements Runnable {
        @Parameters(index = '0') Integer width
        @Parameters(index = '1') Integer height

        void run() {
            def command = new CreateCanvasCommand(width: width, height: height)
            println(app.process(command))
        }
    }

    @Command(name = 'L', description = 'Draw a line')
    static class DrawLine implements Runnable {
        @Parameters(index = '0') Integer coordinate1X
        @Parameters(index = '1') Integer coordinate1Y
        @Parameters(index = '2') Integer coordinate2X
        @Parameters(index = '3') Integer coordinate2Y

        void run() {
            def coordinate1 = new Tuple(coordinate1X, coordinate1Y)
            def coordinate2 = new Tuple(coordinate2X, coordinate2Y)
            def command = new CreateLineCommand(coordinate1: coordinate1, coordinate2: coordinate2)
            println(app.process(command))
        }
    }

    @Command(name = 'R', description = 'Draw a rectangle')
    static class DrawRectangle extends DrawLine implements Runnable {
        void run() {
            def coordinate1 = new Tuple(coordinate1X, coordinate1Y)
            def coordinate2 = new Tuple(coordinate2X, coordinate2Y)
            def command = new CreateRectangleCommand(coordinate1: coordinate1, coordinate2: coordinate2)
            println(app.process(command))
        }
    }

    @Command(name = 'B', description = 'Fill with colour')
    static class Fill implements Runnable {
        @Parameters(index = '0') Integer x
        @Parameters(index = '1') Integer y
        @Parameters(index = '2') Character colour

        void run() {
            def coordinate = new Tuple(x, y)
            def command = new CreateColourCommand(coordinate: coordinate, colour: colour)
            println(app.process(command))
        }
    }

    @Command(name = 'Q', description = 'Quit')
    static class Quit implements Runnable {
        void run() {
            System.exit(0)
        }
    }
}