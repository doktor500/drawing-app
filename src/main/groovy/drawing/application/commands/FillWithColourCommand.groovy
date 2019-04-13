package drawing.application.commands

import drawing.domain.ColourPoint
import drawing.domain.Coordinate

class FillWithColourCommand implements Command<ColourPoint> {

    Tuple<Integer> coordinate
    String colour

    @Override
    ColourPoint execute() {
        new ColourPoint(coordinate: new Coordinate(x: coordinate.first() - 1, y: coordinate.last() - 1), colour: colour)
    }
}
