package com.security.app.services

import com.security.app.model.Message
import com.security.app.model.NotificationStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class CallbackService(
    private val webClient: WebClient
) {
    private final val NOTIFICATION_SERVICE_URL = System.getenv("NOTIFICATION_SERVICE_URL")

    fun sendCallbackNotification(
        notificationId: String,
        channel: String,
        notificationStatus: NotificationStatus,
        fcmToken: String?
    ) {
        webClient.post()
            .uri("${NOTIFICATION_SERVICE_URL}/handle/${notificationId}")
            .bodyValue(
                mapOf(
                    "channel" to channel,
                    "status" to notificationStatus.value,
                    "fcmToken" to fcmToken
                )
            )
            .retrieve()
            .bodyToMono(Message.Success::class.java)
            .subscribe()
    }
}