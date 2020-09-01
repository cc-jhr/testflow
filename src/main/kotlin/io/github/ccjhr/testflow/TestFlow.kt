package io.github.ccjhr.testflow

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

inline infix fun <T> T.mustSatisfy(assertion: (AssertionContext<T>) -> Unit) {
    assertion.invoke(AssertionContext(this))
}

data class AssertionContext<T : Any?>(val content: T)

@OptIn(ExperimentalContracts::class)
fun ensureNotNull(obj: Any?) {
    contract {
        returns() implies (obj != null)
    }
    requireNotNull(obj) { "Object for assertion is null." }
}
