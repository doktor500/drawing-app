package drawing

import drawing.application.commands.AddColourCommand
import drawing.application.commands.Command
import drawing.application.commands.CreateCanvasCommand
import drawing.application.presenters.CanvasPresenter
import drawing.domain.Canvas

class DrawingApp {

    Canvas canvas = new Canvas()

    String process(CreateCanvasCommand createCanvas) {
        run { canvas = createCanvas.execute() }
    }

    String process(Command command) {
        run { canvas = canvas.draw(command.execute()) }
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
