package io.github.ccjhr.testflow

import kotlin.test.fail

infix fun AssertionContext<Int>.isGreaterThan(obj: Int) {
    if (this.content <= obj) {
        fail("Expecting <${this.content}> to be greater than <$obj>, but it's not.")
    }
}
