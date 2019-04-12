package com.github.putopavel

import io.micronaut.context.BeanContext
import org.amshove.kluent.shouldContain
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.net.URL

internal class RemotePdfTextExtractorUseCaseSpek : Spek({
    describe("Remote PDF text extractor use case") {
        val sut = BeanContext.run().getBean(RemotePdfTextExtractorUseCase::class.java)
        context("extract sample PDF's text") {
            val url = URL("http://www.orimi.com/pdf-test.pdf")
            it("should extract all the text") {
                val extractedText = sut.extractText(url)
                extractedText.trim() shouldContain "PDF Test File"
            }
        }
    }
})