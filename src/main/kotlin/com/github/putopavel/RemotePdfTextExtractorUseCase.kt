package com.github.putopavel

import java.net.URL
import javax.inject.Singleton

@Singleton
class RemotePdfTextExtractorUseCase(private val pdfTextExtractorUseCase: PdfTextExtractorUseCase) {
    fun extractText(url: URL): String {
        val stream = url.openStream()
        return pdfTextExtractorUseCase.extractText(stream)
    }
}