/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.ccjhr.testflow

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ListAssertionsTest {

    @Nested
    inner class MustContainTests {

        @Test
        fun `mustContain fails`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = assertThrows<AssertionError> {
                list mustSatisfy {
                    it mustContain "world"
                }
            }

            // then
            assertEquals("Expecting <[List, of, words.]> to be contain <world>, but it doesn't.", result.message)
        }

        @Test
        fun `mustContain successful`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            list mustSatisfy {
                it mustContain "of"
            }
        }
    }

    @Nested
    inner class MustNotContainTests {

        @Test
        fun `mustNotContain fails`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            val result = assertThrows<AssertionError> {
                list mustSatisfy {
                    it mustNotContain "of"
                }
            }

            // then
            assertEquals("Expecting <[List, of, words.]> to NOT contain <of>, but it does.", result.message)
        }

        @Test
        fun `mustNotContain successful`() {
            // given
            val list = listOf("List", "of", "words.")

            // when
            list mustSatisfy {
                it mustNotContain "world"
            }
        }
    }
}
