package io.github.ccjhr.testflow.assertions.any
import io.github.ccjhr.testflow.mustSatisfy
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
                obj mustSatisfy {
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
            obj mustSatisfy {
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
                obj mustSatisfy {
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
            obj mustSatisfy {
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
                obj mustSatisfy {
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
            obj mustSatisfy {
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
                obj mustSatisfy {
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
            obj mustSatisfy {
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
                obj mustSatisfy {
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
            a mustSatisfy {
                it mustBeSameAs b
            }
        }

        @Test
        fun `mustBeSameAs succeeds`() {
            // given
            val obj = 12 to "content"

            // when
            obj mustSatisfy {
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
                obj mustSatisfy {
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
                a mustSatisfy {
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
            obj mustSatisfy {
                it mustNotBeSameAs 12 to "content"
            }
        }
    }
}
