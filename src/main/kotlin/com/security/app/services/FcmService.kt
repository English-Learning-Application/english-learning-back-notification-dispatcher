package com.security.app.services

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.security.app.model.NotificationStatus
import org.springframework.stereotype.Service

@Service
class FcmService(
    private val callbackService: CallbackService,
) {
    fun sendNotificationToToken(
        token: String,
        title: String,
        message: String,
        action: Map<String, String>,
        notificationId: String
    ): String {
        try {
            val messageModel = Message.builder()
                .setToken(token)
                .putAllData(action)
                .setNotification(
                    com.google.firebase.messaging.Notification.builder()
                        .setTitle(title)
                        .setBody(message)
                        .build()
                )
                .build()

            callbackService.sendCallbackNotification(
                notificationId,
                "fcm",
                NotificationStatus.SENT,
                token
            )
            return FirebaseMessaging.getInstance().send(messageModel)
        } catch (e: Exception) {
            callbackService.sendCallbackNotification(
                notificationId,
                "fcm",
                NotificationStatus.FAILED,
                token
            )
            e.printStackTrace()
            return e.message.toString()
        }
    }
}