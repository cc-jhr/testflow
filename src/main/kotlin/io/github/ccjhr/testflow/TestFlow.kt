package io.github.ccjhr.testflow

inline infix fun <T> T.mustSatisfy(assertion: (AssertionContext<T>) -> Unit) {
    assertion.invoke(AssertionContext(this))
}

inline fun <T> assertThat(obj: T, func: (AssertionContext<T>) -> Unit) {
    func.invoke(AssertionContext(obj))
}

data class AssertionContext<T : Any?>(val content: T)
