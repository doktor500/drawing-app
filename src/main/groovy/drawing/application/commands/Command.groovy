package drawing.application.commands

interface Command<TYPE> {
    TYPE execute()
}
