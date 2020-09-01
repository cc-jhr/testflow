package io.github.ccjhr.testflow.assertions.any

import io.github.ccjhr.testflow.AssertionContext
import io.github.ccjhr.testflow.assertions.any.AnyAssertionAdjective.Null
import io.github.ccjhr.testflow.ensureNotNull
import kotlin.reflect.KClass
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustNotBeOfType
 */
infix fun <T : Any?> AssertionContext<T>.mustBeOfType(type: KClass<*>) {
    ensureNotNull(this.content)
    if (!type.isInstance(this.content)) {
        fail("Expecting <${this.content}> to be of type <${type.qualifiedName}>, but is <${this.content.javaClass.kotlin.qualifiedName}>.")
    }
}

/**
 * @since 1.0.0
 * @see mustBeOfType
 */
infix fun <T : Any?> AssertionContext<T>.mustNotBeOfType(type: KClass<*>) {
    ensureNotNull(this.content)
    if (type.isInstance(this.content)) {
        fail("Expecting <${this.content}> not to be of type <${type.qualifiedName}>, but it is.")
    }
}

/**
 * @since 1.0.0
 * @see isNotEqualTo
 */
infix fun <T : Any?> AssertionContext<T>.isEqualTo(other: Any) {
    ensureNotNull(this.content)
    if (this.content != other) {
        fail("Expecting <${this.content}> to be equal to <$other>, but it's not.")
    }
}

/**
 * @since 1.0.0
 * @see isEqualTo
 */
infix fun <T : Any?> AssertionContext<T>.isNotEqualTo(other: Any) {
    ensureNotNull(this.content)
    if (this.content == other) {
        fail("Expecting objects not to be equal, but they are.")
    }
}

/**
 * @since 1.0.0
 * @see mustNotBeSameAs
 */
infix fun <T : Any?> AssertionContext<T>.mustBeSameAs(other: Any) {
    ensureNotNull(this.content)
    if (this.content !== other) {
        fail("Expecting <${this.content.referenceString()}> and <${other.referenceString()}> to point to the same object, but they don't.")
    }
}

/**
 * @since 1.0.0
 * @see mustBeSameAs
 */
infix fun <T : Any?> AssertionContext<T>.mustNotBeSameAs(other: Any) {
    ensureNotNull(this.content)
    if (this.content === other) {
        fail("Expecting objects to point to different object instances, but they point to the same object.")
    }
}

/**
 * @since 1.0.0
 * @see mustBe
 */
infix fun <T: Any?> AssertionContext<T>.mustNotBe(adjective: AnyAssertionAdjective) {
    when(adjective) {
        Null -> this.content ?: fail("Expecting object not to be null, but it is.")
    }
}

/**
 * @since 1.0.0
 * @see mustNotBe
 */
infix fun <T: Any?> AssertionContext<T>.mustBe(adjective: AnyAssertionAdjective) {
    when(adjective) {
        Null -> if(this.content != null) fail("Expecting object to be null, but it's not.")
    }
}

/**
 * @since 1.0.0
 */
enum class AnyAssertionAdjective {
    Null
}

private fun Any.referenceString() = "${this.javaClass.kotlin.qualifiedName}@${System.identityHashCode(this)}"
