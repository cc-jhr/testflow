package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.assertions.any.AnyAssertionAdjective.Null
import io.github.ccjhr.testflow.assertions.any.mustNotBe
import io.github.ccjhr.testflow.assertions.any.isEqualTo
import io.github.ccjhr.testflow.assertions.any.mustBeOfType
import org.junit.jupiter.api.Test

internal class TestFlowTest {

    @Test
    fun `usage test`() {
        val obj = MyObj(12, "", emptyList())

        obj mustSatisfy {
            it mustNotBe Null
            it mustBeOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number isEqualTo 12
            }
        }

        obj mustSatisfy {
            it mustNotBe Null
            it mustBeOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number isEqualTo 12
            }
        }
    }
}

data class MyObj(
    val number: Int,
    val anyObj: Any,
    val list: List<String>
)
