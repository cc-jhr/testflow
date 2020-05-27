package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.StringNullableAssertionAdjective.Blank
import io.github.ccjhr.testflow.StringNullableAssertionAdjective.Empty
import kotlin.test.fail

infix fun <T: String?>AssertionContext<T>.mustNotBe(adjective: StringNullableAssertionAdjective) {
    if (this.content == null) {
        fail("Expecting given String not to be <null>, but it is.")
    }

    when(adjective) {
        Empty -> if(this.content.isEmpty()) fail("Expecting given String not to be null or empty, but was empty.")
        Blank -> if (this.content.isBlank()) fail("Expecting given String not to be null or blank, but was blank.")
    }
}

//TODO: inverse func

enum class StringNullableAssertionAdjective {
    Empty,
    Blank
}
