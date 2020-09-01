package io.github.ccjhr.testflow.assertions.int

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.ensureNotNull
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see isLessThan
 */
infix fun <T: Int?> AssertionContext<T>.isGreaterThan(obj: Int) {
    ensureNotNull(this.content)
    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}

/**
 * @since 1.0.0
 * @see isGreaterThan
 */
infix fun <T: Int?> AssertionContext<T>.isLessThan(obj: Int) {
    ensureNotNull(this.content)
    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}
