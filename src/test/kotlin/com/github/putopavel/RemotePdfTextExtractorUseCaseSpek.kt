package com.github.putopavel

import io.micronaut.context.ApplicationContext
import org.amshove.kluent.`should contain`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.net.URL

internal class RemotePdfTextExtractorUseCaseSpek : Spek({
    val sut = ApplicationContext.run().getBean(RemotePdfTextExtractorUseCase::class.java)
    describe("Extract sample remote PDF's text") {
        context("a URL which points to a PDF") {
            val url = URL("http://www.orimi.com/pdf-test.pdf")
            it("should extract all the text") {
                val extractedText = sut.extractText(url)
                extractedText.trim() `should contain` "PDF Test File"
            }
        }
    }
})