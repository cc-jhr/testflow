package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.AnyNullableAssertionAdjective.Null
import kotlin.test.fail

infix fun <T: Any?> AssertionContext<T>.mustNotBe(adjective: AnyNullableAssertionAdjective) {
    when(adjective) {
        Null -> this.content ?: fail("Expecting not to be null, but it is.")
    }
}

// TODO: inverse func

enum class AnyNullableAssertionAdjective {
    Null
}
