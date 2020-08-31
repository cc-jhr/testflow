package io.github.ccjhr.testflow

import io.github.ccjhr.testflow.AnyNullableAssertionAdjective.Null
import org.junit.jupiter.api.Test

internal class TestFlowTest {

    @Test
    fun `usage test`() {
        val obj: MyObj = MyObj(12, "", emptyList())

        obj mustSatisfy {
            it mustNotBe Null
            it mustBeOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number mustBeEqualTo 12
            }
        }

        obj mustSatisfy {
            it mustNotBe Null
            it mustBeOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number mustBeEqualTo 12
            }
        }
    }
}

data class `MyObj`(
    val number: Int,
    val anyObj: Any,
    val list: List<String>
)
