package com.github.putopavel

import io.micronaut.context.annotation.Value
import java.net.URL
import javax.inject.Singleton
import kotlin.text.RegexOption.IGNORE_CASE
import kotlin.text.RegexOption.MULTILINE

@Singleton
class PassportCheckerUseCase(
        private val remotePdfTextExtractorUseCase: RemotePdfTextExtractorUseCase,
        @Value("\${passports-url}") val passportsListUrl: String,
        @Value("\${expecting-name}") val expectingName: String) {

    fun isPassportReady(name: String = expectingName): Boolean {
        val extractedText = remotePdfTextExtractorUseCase.extractText(URL(passportsListUrl))
        return extractedText.contains(name.toRegex(setOf(IGNORE_CASE, MULTILINE)))
    }
}