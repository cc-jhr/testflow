package io.github.ccjhr.testflow.assertions.any

import io.github.ccjhr.testflow.assertions.any.AnyNullableAssertionAdjective.Null
import io.github.ccjhr.testflow.mustSatisfy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class AnyNullableAssertionsTest {

    @Nested
    inner class MustNotBeTests {

        @Test
        fun `must not be null fails`() {
            // given
            val obj: Any? = null

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe Null
                }
            }

            // then
            assertEquals("Expecting object not to be null, but it is.", result.message)
        }

        @Test
        fun `must not be null succeeds`() {
            // given
            val obj: String? = "test"

            // when
            obj mustSatisfy {
                it mustNotBe Null
            }
        }
    }

    @Nested
    inner class MustBeTests {

        @Test
        fun `must be null fails`() {
            // given
            val obj: Any? = "test"

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it mustBe Null
                }
            }

            // then
            assertEquals("Expecting object to be null, but it's not.", result.message)
        }

        @Test
        fun `must be null succeeds`() {
            // given
            val obj: String? = null

            // when
            obj mustSatisfy {
                it mustBe Null
            }
        }
    }
}
