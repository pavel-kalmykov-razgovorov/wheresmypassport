package com.github.putopavel

import io.micronaut.runtime.Micronaut

@Suppress("unused")
object Application {

    @JvmStatic
    fun main() {
        Micronaut.build()
                .packages("com.github.putopavel")
                .mainClass(Application.javaClass)
                .start()
    }
}