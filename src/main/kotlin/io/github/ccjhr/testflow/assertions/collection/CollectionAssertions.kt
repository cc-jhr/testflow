package io.github.ccjhr.testflow.assertions.collection

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.ensureNotNull
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustNotContain
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.mustContain(obj: T) {
    ensureNotNull(this.content)
    if (!this.content.contains(obj)) {
        fail("Expecting <${this.content}> to be contain <$obj>, but it doesn't.")
    }
}

/**
 * @since 1.0.0
 * @see mustContain
 */
inline infix fun <reified T> AssertionContext<out Collection<T>?>.mustNotContain(obj: T) {
    ensureNotNull(this.content)
    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to NOT contain <$obj>, but it does.")
    }
}
