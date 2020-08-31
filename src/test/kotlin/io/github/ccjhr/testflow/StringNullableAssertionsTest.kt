package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.StringNullableAssertionAdjective.Blank
import io.github.ccjhr.testflow.StringNullableAssertionAdjective.Empty
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class StringNullableAssertionsTest {

    @Nested
    inner class MustNotBeTests {

        @Nested
        inner class MustNotBeEmptyTests {

            @Test
            fun `MustNotBe Empty fails, because string is null`() {
                // given
                val string: String? = null

                // when
                val result = assertThrows<AssertionError> {
                    string mustSatisfy {
                        it mustNotBe Empty
                    }
                }

                // then
                assertEquals("Expecting given String not to be <null>, but it is.", result.message)
            }

            @Test
            fun `MustNotBe Empty fails, because the string is empty`() {
                // given
                val string = ""

                // when
                val result = assertThrows<AssertionError> {
                    string mustSatisfy {
                        it mustNotBe Empty
                    }
                }

                // then
                assertEquals("Expecting given String not to be null or empty, but was empty.", result.message)
            }

            @Test
            fun `MustNotBe Empty succeeds`() {
                // given
                val string: String? = "test"

                // when
                string mustSatisfy {
                    it mustNotBe Empty
                }
            }
        }

        @Nested
        inner class MustNotBeBlankTests {

            @Test
            fun `MustNotBe Blank fails, because string is null`() {
                // given
                val string: String? = null

                // when
                val result = assertThrows<AssertionError> {
                    string mustSatisfy {
                        it mustNotBe Blank
                    }
                }

                // then
                assertEquals("Expecting given String not to be <null>, but it is.", result.message)
            }

            @Test
            fun `MustNotBe Blank fails, because the string contains only whitespaces`() {
                // given
                val string = "       "

                // when
                val result = assertThrows<AssertionError> {
                    string mustSatisfy {
                        it mustNotBe Blank
                    }
                }

                // then
                assertEquals("Expecting given String not to be null or blank, but was blank.", result.message)
            }

            @Test
            fun `MustNotBe Blank succeeds`() {
                // given
                val string: String? = "test"

                // when
                string mustSatisfy {
                    it mustNotBe Blank
                }
            }
        }
    }
}
