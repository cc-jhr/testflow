package io.github.ccjhr.testflow

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnyAssertionsTest {

    @Nested
    inner class MustBeOfTypeTests {

        @Test
        fun `mustBeOfType fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustBeOfType String::class
                }
            }

            // then
            assertEquals("Expecting <12> to be of type <kotlin.String>, but is <kotlin.Int>.", result.message)
        }

        @Test
        fun `mustBeOfType succeeds`() {
            // given
            val obj = 12

            // when
            assertThat(obj) {
                it mustBeOfType Int::class
            }
        }
    }

    @Nested
    inner class MustNotBeOfTypeTests {

        @Test
        fun `mustNotBeOfType fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustNotBeOfType Int::class
                }
            }

            // then
            assertEquals("Expecting <12> NOT to be of type <kotlin.Int>, but it is.", result.message)
        }

        @Test
        fun `mustNotBeOfType succeeds`() {
            // given
            val obj = 12

            // when
            assertThat(obj) {
                it mustNotBeOfType String::class
            }
        }
    }

    @Nested
    inner class MustBeEqualToTests {

        @Test
        fun `mustBeEqualTo fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustBeEqualTo 14
                }
            }

            // then
            assertEquals("Expecting <12> to be equal to <14>, but is not.", result.message)
        }

        @Test
        fun `mustBeEqualTo succeeds`() {
            // given
            val obj = 12

            // when
            assertThat(obj) {
                it mustBeEqualTo 12
            }
        }
    }

    @Nested
    inner class MustNotBeEqualToTests {

        @Test
        fun `mustNotBeEqualTo fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustNotBeEqualTo 12
                }
            }

            // then
            assertEquals("Expecting objects not to be equal, but they are.", result.message)
        }

        @Test
        fun `mustNotBeEqualTo succeeds`() {
            // given
            val obj = 12

            // when
            assertThat(obj) {
                it mustNotBeEqualTo 13
            }
        }
    }

    @Nested
    inner class MustBeSameAsTests {

        @Test
        fun `mustBeSameAs fails`() {
            // given
            val obj = 12 to "content"

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustBeSameAs 12 to "content"
                }
            }

            // then
            assertTrue(result.message!!.contains("to point to the same object, but they don't"))
        }

        @Test
        fun `mustBeSameAs succeeds for different instantiation of Int`() {
            // given
            val a = "12".toInt()
            val b = 12

            // when
            assertThat(a) {
                it mustBeSameAs b
            }
        }

        @Test
        fun `mustBeSameAs succeeds`() {
            // given
            val obj = 12 to "content"

            // when
            assertThat(obj) {
                it mustBeSameAs obj
            }
        }
    }

    @Nested
    inner class MustNotBeSameAsTests {

        @Test
        fun `mustNotBeSameAs fails`() {
            // given
            val obj = 12 to "content"

            // when
            val result = assertThrows<AssertionError> {
                assertThat(obj) {
                    it mustNotBeSameAs obj
                }
            }

            // then
            assertEquals("Expecting objects to point to different object instances, but they point to the same object.", result.message)
        }

        @Test
        fun `mustNotBeSameAs fails for different instantiation of Int`() {
            // given
            val a = "12".toInt()
            val b = 12

            // when
            val result = assertThrows<AssertionError> {
                assertThat(a) {
                    it mustNotBeSameAs b
                }
            }

            // then
            assertEquals("Expecting objects to point to different object instances, but they point to the same object.", result.message)
        }

        @Test
        fun `mustNotBeSameAs succeeds`() {
            // given
            val obj = 12 to "content"

            // when
            assertThat(obj) {
                it mustNotBeSameAs 12 to "content"
            }
        }
    }
}
