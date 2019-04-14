package com.github.putopavel

import io.micronaut.context.ApplicationContext
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal class MailPassportResponseUseCaseTest : Spek({
    describe("sending mail example") {
        val sut = ApplicationContext.run().getBean(MailPassportResponseUseCase::class.java)
        context("settings are correct") {
            it("should send the email without errors") {
                sut.send()
            }
        }
    }
})