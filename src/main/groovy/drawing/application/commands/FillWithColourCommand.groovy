package drawing.application.commands

import drawing.domain.Colour
import drawing.domain.Coordinate

class FillWithColourCommand implements Command<Colour> {

    Tuple<Integer> coordinate
    String colour

    @Override
    Colour execute() {
        new Colour(coordinate: new Coordinate(x: coordinate.first() - 1, y: coordinate.last() - 1), value: colour)
    }
}
