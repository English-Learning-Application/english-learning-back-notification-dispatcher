package com.security.app.services

import com.twilio.http.TwilioRestClient
import com.twilio.rest.api.v2010.account.Message
import com.twilio.rest.api.v2010.account.Message.Status
import com.twilio.type.PhoneNumber
import org.springframework.stereotype.Service

@Service
class SmsService(
    private val twilioRestClient: TwilioRestClient
) {
    private final val fromNumber = System.getenv("TWILIO_PHONE_NUMBER")
    fun sendSms(phoneNumber: String, message: String): Status {
        val twilioMessageModel = Message.creator(
            PhoneNumber(phoneNumber),
            PhoneNumber(fromNumber),
            message,
        ).create(twilioRestClient)

        return twilioMessageModel.status
    }
}