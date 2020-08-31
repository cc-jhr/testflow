package io.github.ccjhr.testflow

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class IntAssertionsKtTest {

    @Nested
    inner class IsGreaterThanTests {

        @Test
        fun `isGreaterThan fails for equal value`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isGreaterThan 12
                }
            }

            // then
            assertEquals("Expecting <12> to be greater than <12>, but it's not.", result.message)
        }

        @Test
        fun `isGreaterThan fails for greater value`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isGreaterThan 13
                }
            }

            // then
            assertEquals("Expecting <12> to be greater than <13>, but it's not.", result.message)
        }

        @Test
        fun `isGreaterThan succeeds`() {
            // given
            val obj = 12

            // when
            obj mustSatisfy {
                it isGreaterThan 11
            }
        }
    }
}
