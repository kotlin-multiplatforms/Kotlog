package io.github.kotlinmp.kotlog

import kotlin.test.Test
import kotlin.test.assertEquals

class TestPlatformDependedFeatures {
    @Test
    fun testColor() {
        PlatformDependedFeatures.makeStacktrace(Throwable("asdf")).forEach {
            println(it)
        }
    }

    @Test
    fun testFormat() {
        assertEquals(
            PlatformDependedFeatures.format("%s is over %d", "FinalChild", "9000"),
            "FinalChild is over 9000"
        )
    }
}
