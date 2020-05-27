package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.AnyNullableAssertionAdjective.Null
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
                assertThat(obj) {
                    it mustNotBe Null
                }
            }

            // then
            assertEquals("Expecting not to be null, but it is.", result.message)
        }

        @Test
        fun `must not be null succeeds`() {
            // given
            val obj: String? = "test"

            // when
            assertThat(obj) {
                it mustNotBe Null
            }
        }
    }
}
