package com.security.app.services

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import org.springframework.stereotype.Service

@Service
class FcmService {
    fun sendNotificationToToken(
        token: String,
        title: String,
        message: String,
        data: Map<String, String>
    ): String {
        try {
            val messageModel = Message.builder()
                .setToken(token)
                .putAllData(data)
                .setNotification(
                    com.google.firebase.messaging.Notification.builder()
                        .setTitle(title)
                        .setBody(message)
                        .build()
                )
                .build()

            return FirebaseMessaging.getInstance().send(messageModel)
        } catch (e: Exception) {
            throw Exception("Error sending notification to token: $token")
        }
    }
}