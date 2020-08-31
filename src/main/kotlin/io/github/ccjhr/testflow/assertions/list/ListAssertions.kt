package io.github.ccjhr.testflow.assertions.list

import io.github.ccjhr.testflow.AssertionContext
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustNotContain
 */
infix fun <T> AssertionContext<List<T>>.mustContain(obj: T) {
    if (!this.content.contains(obj)) {
        fail("Expecting <${this.content}> to be contain <$obj>, but it doesn't.")
    }
}

/**
 * @since 1.0.0
 * @see mustContain
 */
infix fun <T> AssertionContext<List<T>>.mustNotContain(obj: T) {
    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to NOT contain <$obj>, but it does.")
    }
}
