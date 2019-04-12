package drawing.application

import static drawing.application.Characters.getNEW_LINE

class StringUtils {

    static format(String text) {
        text.readLines().tail()*.trim().join(NEW_LINE).trim()
    }
}
