package drawing.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.TailRecursive
import groovy.transform.TupleConstructor

import static drawing.domain.Characters.*

@EqualsAndHashCode
class Canvas {

    final Integer width
    final Integer height
    final List matrix

    Canvas(Integer width = 0, Integer height = 0, List matrix = []) {
        this.width = width
        this.height = height
        this.matrix = matrix ?: initMatrix()
    }

    Canvas draw(Line line) {
        new Canvas(width, height, createNewMatrix(line.coordinates))
    }

    Canvas draw(Rectangle rectangle) {
        rectangle.lines.inject(this) { canvas, line -> canvas.draw(line) }
    }

    Canvas fill(Coordinate coordinate, String newColour) {
        def currentColour = matrix[coordinate.y][coordinate.x]
        def colourInfo = new ColourInfo(currentColour, newColour)
        def coordinates = colour(colourInfo, [coordinate] as Set)
        new Canvas(width, height, createNewMatrix(coordinates, colourInfo.newColour))
    }

    boolean isEmpty() {
        width == 0 && height == 0
    }

    private List initMatrix() {
        (0 ..< height).collect {
            (0 ..< width).collect { SPACE }
        }
    }

    private List createNewMatrix(Set coordinatesToFill, String newValue = CROSS) {
        (0 ..< height).collect { row ->
            (0 ..< width).collect { column ->
                def fillCoordinate = (new Coordinate(column, row) in coordinatesToFill)
                def currentValue = matrix[row][column]
                fillCoordinate ? newValue : currentValue
            }
        }
    }

    @TailRecursive
    private Set colour(ColourInfo colourInfo, Set remainingCoordinates, Set processedCoordinates = []) {
        if (remainingCoordinates.empty) return processedCoordinates
        def currentCoordinate = remainingCoordinates.find()
        def neighbors = validNeighbors(currentCoordinate, colourInfo, processedCoordinates)
        def coordinatesSoFar = processedCoordinates << currentCoordinate
        colour(colourInfo, remainingCoordinates - currentCoordinate + neighbors, coordinatesSoFar)
    }

    private Set validNeighbors(Coordinate currentCoordinate, ColourInfo colourInfo, Set processedCoordinates) {
        def neighborsInMatrix = currentCoordinate.neighbors.findAll { isCoordinateInMatrix(it) }
        def nonProcessedNeighbors = neighborsInMatrix.findAll { !(it in processedCoordinates) }
        def neighborsWithSameColour = nonProcessedNeighbors.findAll { coordinateHasSameColour(it, colourInfo) }
        neighborsWithSameColour
    }

    private boolean isCoordinateInMatrix(Coordinate coordinate) {
        coordinate.x in (0 ..< width) && coordinate.y in (0 ..< height)
    }

    private boolean coordinateHasSameColour(Coordinate coordinate, ColourInfo colourInfo) {
        matrix[coordinate.y][coordinate.x] == colourInfo.currentColour
    }
}

@TupleConstructor
class ColourInfo {
    String currentColour
    String newColour
}
