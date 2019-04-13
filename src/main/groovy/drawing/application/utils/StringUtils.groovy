package drawing.application.utils

import drawing.domain.Characters

class StringUtils {

    static format(String text) {
        text.readLines().tail()*.trim().join(Characters.NEW_LINE).trim()
    }
}
