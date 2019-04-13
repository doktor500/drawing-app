package drawing

import drawing.application.commands.DrawCanvasCommand
import drawing.application.commands.DrawLineCommand
import drawing.application.commands.DrawRectangleCommand
import drawing.application.commands.FillWithColourCommand
import drawing.application.presenters.CanvasPresenter
import drawing.domain.Canvas
import drawing.infrastructure.Console

class DrawingApp {

    private Canvas canvas
    private Console console

    void process(DrawCanvasCommand command) {
        canvas = command.execute()
    }

    void process(DrawLineCommand command) {
        def line = command.execute()
        canvas = canvas.drawLine(line)
    }

    void process(DrawRectangleCommand command) {
        def rectangle = command.execute()
        canvas = canvas.drawRectangle(rectangle)
    }

    void process(FillWithColourCommand command) {
        def colour = command.execute()
        canvas = canvas.fillWithColour(colour)
    }

    void print() {
        def canvasPresenter = canvas as CanvasPresenter
        console.print(canvasPresenter.present())
    }
}
