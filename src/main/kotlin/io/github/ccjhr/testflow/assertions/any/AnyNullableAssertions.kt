package io.github.ccjhr.testflow.assertions.any

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.assertions.any.AnyNullableAssertionAdjective.Null
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustBe
 */
infix fun <T: Any?> AssertionContext<T>.mustNotBe(adjective: AnyNullableAssertionAdjective) {
    when(adjective) {
        Null -> this.content ?: fail("Expecting object not to be null, but it is.")
    }
}

/**
 * @since 1.0.0
 * @see mustNotBe
 */
infix fun <T: Any?> AssertionContext<T>.mustBe(adjective: AnyNullableAssertionAdjective) {
    when(adjective) {
        Null -> if(this.content != null) fail("Expecting object to be null, but it's not.")
    }
}

/**
 * @since 1.0.0
 */
enum class AnyNullableAssertionAdjective {
    Null
}
