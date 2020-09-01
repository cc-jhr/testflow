package io.github.ccjhr.testflow.assertions.collection

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.ensureNotNull
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustNotContain
 */
infix fun <C: Collection<T>?, T> AssertionContext<C>.mustContain(obj: T) {
    ensureNotNull(this.content)
    if (!this.content.contains(obj)) {
        fail("Expecting <${this.content}> to be contain <$obj>, but it doesn't.")
    }
}

/**
 * @since 1.0.0
 * @see mustContain
 */
infix fun <C: Collection<T>?, T> AssertionContext<C>.mustNotContain(obj: T) {
    ensureNotNull(this.content)
    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to NOT contain <$obj>, but it does.")
    }
}
