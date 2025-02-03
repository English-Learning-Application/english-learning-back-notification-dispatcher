package com.security.app.services

import com.security.app.model.NotificationStatus
import com.twilio.http.TwilioRestClient
import com.twilio.rest.api.v2010.account.Message
import com.twilio.rest.api.v2010.account.Message.Status
import com.twilio.type.PhoneNumber
import org.springframework.stereotype.Service

@Service
class SmsService(
    private val twilioRestClient: TwilioRestClient,
    private val callbackService: CallbackService,
) {
    private final val fromNumber = System.getenv("TWILIO_PHONE_NUMBER")
    fun sendSms(phoneNumber: String, message: String, notificationId: String): Status {
        try {
            val twilioMessageModel = Message.creator(
                PhoneNumber(phoneNumber),
                PhoneNumber(fromNumber),
                message,
            ).create(twilioRestClient)

            callbackService.sendCallbackNotification(notificationId, "sms", NotificationStatus.SENT, null)
            return twilioMessageModel.status
        } catch (e: Exception) {
            e.printStackTrace()
            callbackService.sendCallbackNotification(notificationId, "sms", NotificationStatus.FAILED, null)
            return Status.FAILED
        }
    }
}