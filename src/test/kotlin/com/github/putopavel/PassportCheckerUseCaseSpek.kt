package com.github.putopavel

import io.micronaut.context.ApplicationContext
import org.amshove.kluent.`should be equal to`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal class PassportCheckerUseCaseSpek : Spek({
    describe("getting Passport's URL from properties") {
        val sut = ApplicationContext.run().getBean(PassportCheckerUseCase::class.java)
        context("having the bean instantiated") {
            it("should give the URL written in the .yml file") {
                sut.passportsListUrl `should be equal to` "https://spain.mid.ru/documents/1803126/23784574/razr1.pdf"
            }
            it("should give the expecting name written in the .yml file") {
                sut.expectingName `should be equal to` "РАЗГОВОРОВ"
            }
        }
        context("having your passport ready") {
            it("should return true") {
                val ready = sut.isPassportReady(name = "ГУСЕВ МАРК")
                ready `should be equal to` true
            }
        }
        context("not having your passport ready") {
            it("should return false") {
                val ready = sut.isPassportReady(name = "НЕ СУЩЕСТВУЕТ")
                ready `should be equal to` false
            }
        }
    }
})