package io.github.ccjhr.testflow.assertions.collection

import io.github.ccjhr.testflow.mustSatisfy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class ListAssertionsTest {

    @Nested
    inner class MustContainTests {

        @Test
        fun `mustContain throws exception if the object is null`() {
            // given
            val obj: Collection<String>? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustContain "test"
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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
        fun `mustNotContain throws exception if the object is null`() {
            // given
            val obj: Collection<String>? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustNotContain "test"
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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
