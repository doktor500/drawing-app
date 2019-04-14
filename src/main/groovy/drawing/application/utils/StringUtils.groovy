package drawing.application.utils

import static drawing.domain.Characters.*

class StringUtils {

    static String format(String text) {
        text.readLines().tail()*.trim().join(NEW_LINE).trim()
    }
}
