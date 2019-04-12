package com.github.putopavel

import io.micronaut.context.BeanContext
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.io.FileInputStream


internal class PdfTextExtractorUseCaseSpek : Spek({
    describe("PDF text extractor use case") {
        val sut = BeanContext.run().getBean(PdfTextExtractorUseCase::class.java)
        on("extract sample PDF's text") {
            val stream = FileInputStream("src/test/resources/test.pdf")
            it("should extract all the text") {
                val extractedText = sut.extractText(stream)
                extractedText.trim() shouldEqual "This is a test"
            }
        }
    }
})