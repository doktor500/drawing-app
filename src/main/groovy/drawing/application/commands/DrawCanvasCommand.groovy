package drawing.application.commands

import drawing.domain.Canvas

class DrawCanvasCommand implements Command<Canvas> {

    private Integer width
    private Integer height

    @Override
    Canvas execute() {
        new Canvas(width, height)
    }
}
