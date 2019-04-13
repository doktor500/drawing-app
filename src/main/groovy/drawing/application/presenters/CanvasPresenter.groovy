package drawing.application.presenters


import static drawing.domain.Characters.*
import static drawing.application.utils.StringUtils.format

trait CanvasPresenter {

    abstract Integer getWidth()
    abstract Integer getHeight()
    abstract List getMatrix()
    abstract boolean isEmpty()

    String present() {
        isEmpty() ? EMPTY : format(printCanvas())
    }

    private printCanvas() {
        """
            ${printEdgeRow()}
            ${printMatrix()}
            ${printEdgeRow()}
        """
    }

    private printMatrix() {
        (0..height - 1).collect { column -> printRow(column) }.join(NEW_LINE)
    }

    private printRow(Integer column) {
        PIPE + (0..width - 1).collect { row -> matrix[row][column] }.join() + PIPE
    }

    private printEdgeRow() {
        (0..width + 1).collect { SEPARATOR }.join()
    }
}
