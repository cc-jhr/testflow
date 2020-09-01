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
        fun `mustBeOfType throws exception if the object is null`() {
            // given
            val obj: Int? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustBeOfType Int::class
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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
        fun `mustNotBeOfType throws exception if the object is null`() {
            // given
            val obj: Int? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustNotBeOfType Int::class
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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
            assertEquals("Expecting <12> not to be of type <kotlin.Int>, but it is.", result.message)
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
    inner class IsEqualToTests {

        @Test
        fun `isEqualTo throws exception if the object is null`() {
            // given
            val obj: Int? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it isEqualTo 12
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

        @Test
        fun `mustBeEqualTo fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isEqualTo 14
                }
            }

            // then
            assertEquals("Expecting <12> to be equal to <14>, but it's not.", result.message)
        }

        @Test
        fun `mustBeEqualTo succeeds`() {
            // given
            val obj = 12

            // when
            obj mustSatisfy {
                it isEqualTo 12
            }
        }
    }

    @Nested
    inner class IsNotEqualToTests {

        @Test
        fun `isNotEqualTo throws exception if the object is null`() {
            // given
            val obj: Int? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it isNotEqualTo 12
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

        @Test
        fun `mustNotBeEqualTo fails`() {
            // given
            val obj = 12

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it isNotEqualTo 12
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
                it isNotEqualTo 13
            }
        }
    }

    @Nested
    inner class MustBeSameAsTests {

        @Test
        fun `mustBeSameAs throws exception if the object is null`() {
            // given
            val obj: Pair<Int, String>? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustBeSameAs 12 to "content"
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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
        fun `mustNotBeSameAs throws exception if the object is null`() {
            // given
            val obj: Pair<Int, String>? = null

            // when
            val result = assertThrows<IllegalArgumentException> {
                obj mustSatisfy {
                    it mustBeSameAs 12 to "content"
                }
            }

            // then
            assertEquals("Object for assertion is null.", result.message)
        }

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

    @Nested
    inner class MustNotBeTests {

        @Test
        fun `mustNotBe null fails`() {
            // given
            val obj: Any? = null

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it mustNotBe AnyAssertionAdjective.Null
                }
            }

            // then
            assertEquals("Expecting object not to be null, but it is.", result.message)
        }

        @Test
        fun `mustNotBe null succeeds`() {
            // given
            val obj: String? = "test"

            // when
            obj mustSatisfy {
                it mustNotBe AnyAssertionAdjective.Null
            }
        }
    }

    @Nested
    inner class MustBeTests {

        @Test
        fun `mustBe null fails`() {
            // given
            val obj: Any? = "test"

            // when
            val result = assertThrows<AssertionError> {
                obj mustSatisfy {
                    it mustBe AnyAssertionAdjective.Null
                }
            }

            // then
            assertEquals("Expecting object to be null, but it's not.", result.message)
        }

        @Test
        fun `mustBe null succeeds`() {
            // given
            val obj: String? = null

            // when
            obj mustSatisfy {
                it mustBe AnyAssertionAdjective.Null
            }
        }
    }
}
