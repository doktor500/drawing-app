package drawing

import drawing.application.CreateCanvasCommand
import drawing.domain.Canvas
import drawing.infrastructure.Console

class DrawingApp {

    private Canvas canvas
    private Console console

    void process(CreateCanvasCommand command) {
        canvas = command.execute()
    }

    void print() {
        console.print(canvas.toString())
    }
}
