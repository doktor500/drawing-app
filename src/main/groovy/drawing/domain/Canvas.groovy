package drawing.domain

import groovy.transform.EqualsAndHashCode

import static Characters.*

@EqualsAndHashCode
class Canvas {

    Integer width = 0
    Integer height = 0
    List matrix = []

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
        def colourInfo = new ColourInfo(currentColour: currentColour, newColour: newColour)
        def coordinates = fillArea(coordinate, colourInfo)
        new Canvas(width, height, createNewMatrix(coordinates, colourInfo.newColour))
    }

    boolean isEmpty() {
        width == 0 && height == 0
    }

    private List initMatrix() {
        (0..<height).collect {
            (0..<width).collect { SPACE }
        }
    }

    private List createNewMatrix(Set coordinates, String value = CROSS) {
        (0..<height).collect { row ->
            (0..<width).collect { column -> (new Coordinate(column, row) in coordinates) ? value : matrix[row][column] }
        }
    }

    private Set fillArea(Coordinate currentCoordinate, ColourInfo colourInfo, Set processedCoordinates = []) {
        def neighbors = validNeighbors(currentCoordinate, colourInfo, processedCoordinates)
        neighbors.inject(processedCoordinates << currentCoordinate) { coordinates, neighbor ->
            fillArea(neighbor, colourInfo, coordinates + neighbors)
        }
    }

    private Set validNeighbors(Coordinate currentCoordinate, ColourInfo colourInfo, Set processedCoordinates) {
        def neighborsInMatrix = currentCoordinate.neighbors.findAll { it.x in (0..<width) && it.y in (0..<height) }
        def nonProcessedNeighbors = neighborsInMatrix.findAll { !(it in processedCoordinates) }
        nonProcessedNeighbors.findAll { matrix[it.y][it.x] == colourInfo.currentColour }
    }
}

class ColourInfo {
    String currentColour
    String newColour
}
