package drawing

import drawing.application.commands.CreateCanvasCommand
import drawing.application.presenters.CanvasPresenter
import drawing.infrastructure.Console

class DrawingApp {

    private CanvasPresenter canvas
    private Console console

    void process(CreateCanvasCommand command) {
        canvas = command.execute() as CanvasPresenter
    }

    void print() {
        console.print(canvas.present())
    }
}
