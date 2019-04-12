package drawing.application.utils

class StringUtils {

    static format(String text) {
        text.readLines().tail()*.trim().join(Characters.NEW_LINE).trim()
    }
}
