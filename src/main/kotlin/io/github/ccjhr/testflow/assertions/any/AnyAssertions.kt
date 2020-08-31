package io.github.ccjhr.testflow.assertions.any

import io.github.ccjhr.testflow.AssertionContext
import kotlin.reflect.KClass
import kotlin.test.fail

/**
 * @since 1.0.0
 * @see mustNotBeOfType
 */
infix fun <T : Any> AssertionContext<T>.mustBeOfType(type: KClass<*>) {
    if (!type.isInstance(this.content)) {
        fail("Expecting <${this.content}> to be of type <${type.qualifiedName}>, but is <${this.content.javaClass.kotlin.qualifiedName}>.")
    }
}

/**
 * @since 1.0.0
 * @see mustBeOfType
 */
infix fun <T : Any> AssertionContext<T>.mustNotBeOfType(type: KClass<*>) {
    if (type.isInstance(this.content)) {
        fail("Expecting <${this.content}> NOT to be of type <${type.qualifiedName}>, but it is.")
    }
}

/**
 * @since 1.0.0
 * @see mustNotBeEqualTo
 */
infix fun <T : Any> AssertionContext<T>.mustBeEqualTo(other: Any) {
    if (this.content != other) {
        fail("Expecting <${this.content}> to be equal to <$other>, but is not.")
    }
}

/**
 * @since 1.0.0
 * @see mustBeEqualTo
 */
infix fun <T : Any> AssertionContext<T>.mustNotBeEqualTo(other: Any) {
    if (this.content == other) {
        fail("Expecting objects not to be equal, but they are.")
    }
}

/**
 * @since 1.0.0
 * @see mustNotBeSameAs
 */
infix fun <T : Any> AssertionContext<T>.mustBeSameAs(other: Any) {
    if (this.content !== other) {
        fail("Expecting <${this.content.referenceString()}> and <${other.referenceString()}> to point to the same object, but they don't.")
    }
}

/**
 * @since 1.0.0
 * @see mustBeSameAs
 */
infix fun <T : Any> AssertionContext<T>.mustNotBeSameAs(other: Any) {
    if (this.content === other) {
        fail("Expecting objects to point to different object instances, but they point to the same object.")
    }
}

private fun Any.referenceString() = "${this.javaClass.kotlin.qualifiedName}@${System.identityHashCode(this)}"
