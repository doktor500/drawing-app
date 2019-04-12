package drawing.application

interface Command<TYPE> {
    TYPE execute()
}
