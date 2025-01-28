package com.security.app.config

import com.twilio.http.TwilioRestClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SmsConfiguration {
    private final val ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID")
    private final val AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN")

    @Bean
    fun twilioClient(): TwilioRestClient {
        val twilioRestClient = TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN).build()
        return twilioRestClient
    }
}