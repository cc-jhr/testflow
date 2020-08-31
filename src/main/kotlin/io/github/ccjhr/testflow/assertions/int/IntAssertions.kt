package io.github.ccjhr.testflow.assertions.int

import io.github.ccjhr.testflow.AssertionContext
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see isLessThan
 */
infix fun AssertionContext<Int>.isGreaterThan(obj: Int) {
    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}

/**
 * @since 1.0.0
 * @see isGreaterThan
 */
infix fun AssertionContext<Int>.isLessThan(obj: Int) {
    if (this.content >= obj) {
        fail("Expecting <${this.content}> to be less than <$obj>, but it's not.")
    }
}
