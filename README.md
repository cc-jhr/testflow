# TestFlow

A small test creating an assertion/matcher with infix functions.
Easily extendable using extension functions.

Origin of a test is the object itsef. The object must satisfy criteria
```kotlin
    @Test
    fun `usage test`() {
        12 mustSatisfy {
            
        }
    }
```

Various criteria can be described based on the type
```kotlin
    @Test
    fun `usage test`() {
        12 mustSatisfy {
            it mustBeOfType Int::class
        }
    }
```

Nullability can be checked using additional adjectives:
```kotlin
    @Test
    fun `usage test`() {
        val obj:  String? = null
        
        obj mustSatisfy {
            it mustNotBe Null
        }
    }
```

Checking a parameter of a more complex object can be achieved using a nested `mustSatisfy` block:
```kotlin
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
    }

    data class `MyObj`(
        val number: Int,
        val anyObj: Any,
        val list: List<String>
    )
```

Alternatively starting a test with the well established `assertThat` is possible as well:

```kotlin
    @Test
    fun `usage test`() {
        assertThat(obj) {
            it mustNotBe Null
            it mustBeOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number mustBeEqualTo 12
            }
        }
    }
```