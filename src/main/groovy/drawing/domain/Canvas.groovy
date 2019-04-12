package drawing.domain

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Canvas {

    private Integer width = 0
    private Integer height = 0
    private List<Cell> cells = []

    Canvas() {

    }

    Canvas(Integer width, Integer height) {
        this.width = width
        this.height = height
        this.cells = new ArrayList<>(width * height)
    }

    String toString() {
        ''
    }

}
