package drawing

import drawing.application.commands.DrawCanvasCommand
import drawing.application.commands.DrawLineCommand
import drawing.application.commands.DrawRectangleCommand
import drawing.application.presenters.CanvasPresenter
import drawing.infrastructure.Console

class DrawingApp {

    private CanvasPresenter canvas
    private Console console

    void process(DrawCanvasCommand command) {
        canvas = command.execute() as CanvasPresenter
    }

    void process(DrawLineCommand command) {
        def line = command.execute()
        canvas = canvas.drawLine(line) as CanvasPresenter
    }

    void process(DrawRectangleCommand command) {
        def rectangle = command.execute()
        canvas = rectangle.lines.inject(canvas) { canvas, line -> canvas.drawLine(line) } as CanvasPresenter
    }

    void print() {
        console.print(canvas.present())
    }
}
