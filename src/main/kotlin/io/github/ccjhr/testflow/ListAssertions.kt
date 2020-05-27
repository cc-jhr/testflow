package io.github.ccjhr.testflow

import kotlin.test.fail


infix fun <T> AssertionContext<List<T>>.mustContain(obj: T) {
    if (!this.content.contains(obj)) {
        fail("Expecting <${this.content}> to be contain <$obj>, but it doesn't.")
    }
}

infix fun <T> AssertionContext<List<T>>.mustNotContain(obj: T) {
    if (this.content.contains(obj)) {
        fail("Expecting <${this.content}> to NOT contain <$obj>, but it does.")
    }
}
