package com.github.putopavel

import io.micronaut.context.annotation.Value
import org.slf4j.LoggerFactory
import java.net.URL
import javax.inject.Singleton
import kotlin.text.RegexOption.IGNORE_CASE
import kotlin.text.RegexOption.MULTILINE

@Singleton
class PassportCheckerUseCase(
        private val remotePdfTextExtractorUseCase: RemotePdfTextExtractorUseCase,
        @Value("\${passports.url}") val passportsListUrl: String,
        @Value("\${passports.expecting-name}") val expectingName: String) {

    fun isPassportReady(name: String = expectingName): Boolean {
        val extractedText = remotePdfTextExtractorUseCase.extractText(URL(passportsListUrl))
        val contains = extractedText.contains(name.toRegex(setOf(IGNORE_CASE, MULTILINE)))
        LOG.info("$name's passport is ${if (contains) "" else "not"} ready${if (contains) "!" else "."}")
        return contains
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(PassportCheckerUseCase::class.java)
    }
}