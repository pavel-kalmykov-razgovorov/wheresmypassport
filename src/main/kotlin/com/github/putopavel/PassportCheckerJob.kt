package com.github.putopavel

import io.micronaut.scheduling.annotation.Scheduled
import javax.inject.Singleton

@Suppress("unused")
@Singleton
class PassportCheckerJob(
        private val passportCheckerUseCase: PassportCheckerUseCase) {

    @Scheduled(cron = "\${passports.cron}")
    fun execute() {
        passportCheckerUseCase.sendMailIfReady()
    }
}