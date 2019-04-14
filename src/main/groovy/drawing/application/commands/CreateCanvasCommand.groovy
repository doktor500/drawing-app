package drawing.application.commands

import drawing.domain.Canvas

class CreateCanvasCommand implements Command<Canvas> {

    private Integer width
    private Integer height

    @Override
    Canvas execute() {
        new Canvas(width, height)
    }
}
