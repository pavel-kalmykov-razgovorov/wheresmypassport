package com.github.putopavel

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.pdf.PDFParser
import org.apache.tika.sax.BodyContentHandler
import java.io.InputStream
import javax.inject.Singleton

@Singleton
class PdfTextExtractorUseCase {
    fun extractText(stream: InputStream): String {
        val parser = PDFParser()
        val handler = BodyContentHandler()
        val metadata = Metadata()
        val context = ParseContext()
        parser.parse(stream, handler, metadata, context)
        return handler.toString()
    }
}