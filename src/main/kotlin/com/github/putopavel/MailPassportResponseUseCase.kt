package com.github.putopavel

import io.micronaut.context.annotation.Value
import org.apache.commons.mail.HtmlEmail
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class MailPassportResponseUseCase(
        @Value("\${mail.smtp.ssl}") private val useSSL: Boolean,
        @Value("\${mail.smtp.tls}") private val useTLS: Boolean,
        @Value("\${mail.smtp.timeout}") private val timeout: Int,
        @Value("\${mail.smtp.host}") private val host: String,
        @Value("\${mail.smtp.port}") private val port: Int,
        @Value("\${mail.smtp.username}") private val username: String,
        @Value("\${mail.smtp.password}") private val password: String,
        @Value("\${mail.smtp.transmitter}") private val transmitter: String,
        @Value("\${mail.smtp.recipient}") private val recipient: String,
        @Value("\${passports.url}") private val passportsListUrl: String
) {
    fun send(to: String = recipient) {
        HtmlEmail().apply {
            isSSLOnConnect = useSSL
            isStartTLSEnabled = useTLS
            socketTimeout = timeout
            socketConnectionTimeout = timeout

            hostName = host
            setSmtpPort(port)
            setAuthentication(username, password)

            setFrom(transmitter)
            addTo(to)

            subject = "Your passport is ready!"
            //language=HTML
            setHtmlMsg("<p><a href='$passportsListUrl'>check it out!</a></p>")

            LOG.info("Sending mail to $to...")
            send()
            LOG.info("Mail sent to $to successfully")
        }
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(MailPassportResponseUseCase::class.java)
    }
}