package io.github.ccjhr.testflow

inline infix fun <T> T.mustSatisfy(assertion: (AssertionContext<T>) -> Unit) {
    assertion.invoke(AssertionContext(this))
}

data class AssertionContext<T : Any?>(val content: T)
