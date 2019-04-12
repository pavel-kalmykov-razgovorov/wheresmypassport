package com.github.putopavel

import io.micronaut.context.ApplicationContext
import org.amshove.kluent.`should be equal to`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.io.FileInputStream


internal class PdfTextExtractorUseCaseSpek : Spek({
    val sut = ApplicationContext.run().getBean(PdfTextExtractorUseCase::class.java)
    describe("Extract sample PDF's text") {
        context("a basic PDF with text only") {
            val stream = FileInputStream("src/test/resources/test.pdf")
            it("should extract all the text") {
                val extractedText = sut.extractText(stream)
                extractedText.trim() `should be equal to` "This is a test"
            }
        }
    }
})