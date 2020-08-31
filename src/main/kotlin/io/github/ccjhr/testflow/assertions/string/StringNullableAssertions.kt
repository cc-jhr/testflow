package io.github.ccjhr.testflow.assertions.string

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.assertions.string.StringNullableAssertionAdjective.*
import kotlin.test.fail

/**
 * @since 1.0.0
 */
infix fun <T: String?> AssertionContext<T>.mustNotBe(adjective: StringNullableAssertionAdjective) {
    val obj = this.content

    when(adjective) {
        Null -> if(obj == null) fail("Expecting given String not to be <null>, but it is.")
        Blank -> if (obj == null || obj.isBlank()) fail("Expecting given String not to be <null> or <blank>, but was <blank>.")
        Empty -> if (obj == null || obj.isEmpty()) fail("Expecting given String not to be <null> or <empty>, but was <empty>.")
    }
}

//TODO: inverse func

enum class StringNullableAssertionAdjective {
    Null,
    Empty,
    Blank
}
