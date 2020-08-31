package io.github.ccjhr.testflow.assertions.int

import io.github.ccjhr.testflow.mustSatisfy
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

    @Nested
    inner class IsLessThanTests {

        @Test
        fun `isLessThan fails for equal value`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isLessThan  12
                }
            }

            // then
            assertEquals("Expecting <12> to be less than <12>, but it's not.", result.message)
        }

        @Test
        fun `isLessThan fails for lesser value`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isLessThan  11
                }
            }

            // then
            assertEquals("Expecting <12> to be less than <11>, but it's not.", result.message)
        }

        @Test
        fun `isLessThan succeeds`() {
            // given
            val obj = 12

            // when
            obj mustSatisfy {
                it isLessThan  13
            }
        }
    }
}
