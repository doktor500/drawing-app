package drawing

import drawing.application.commands.CreateCanvasCommand
import drawing.application.commands.CreateLineCommand
import drawing.application.commands.CreateRectangleCommand
import drawing.application.commands.AddColourCommand
import drawing.application.commands.CreateTriangleCommand
import drawing.application.presenters.CanvasPresenter
import drawing.domain.Canvas

class DrawingApp {

    Canvas canvas = new Canvas()

    String process(CreateCanvasCommand createCanvas) {
        run { canvas = createCanvas.execute() }
    }

    String process(CreateLineCommand createLine) {
        run { canvas = canvas.draw(createLine.execute()) }
    }

    String process(CreateRectangleCommand createRectangle) {
        run { canvas = canvas.draw(createRectangle.execute()) }
    }

    String process(CreateTriangleCommand createTriangle) {
        run { canvas = canvas.draw(createTriangle.execute()) }
    }

    String process(AddColourCommand createColour) {
        run {
            def colourPoint = createColour.execute()
            canvas = canvas.fill(colourPoint.coordinate, colourPoint.colour)
        }
    }

    private run = { command ->
        command()
        (canvas as CanvasPresenter).present()
    }
}
