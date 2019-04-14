package drawing

import drawing.application.commands.DrawCanvasCommand
import drawing.application.commands.DrawLineCommand
import drawing.application.commands.DrawRectangleCommand
import drawing.application.commands.FillWithColourCommand
import drawing.application.presenters.CanvasPresenter
import drawing.domain.Canvas

class DrawingApp {

    Canvas canvas = new Canvas()

    String process(DrawCanvasCommand createCanvas) {
        run { canvas = createCanvas.execute() }
    }

    String process(DrawLineCommand createLine) {
        run { canvas = canvas.draw(createLine.execute()) }
    }

    String process(DrawRectangleCommand createRectangle) {
        run { canvas = canvas.draw(createRectangle.execute()) }
    }

    String process(FillWithColourCommand createColourPoint) {
        run {
            def colourPoint = createColourPoint.execute()
            canvas = canvas.fill(colourPoint.coordinate, colourPoint.colour)
        }
    }

    private run = { command ->
        command()
        (canvas as CanvasPresenter).present()
    }
}
