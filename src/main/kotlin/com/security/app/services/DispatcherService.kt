package com.security.app.services

import com.security.app.utils.JsonUtils
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.sqs.SqsAsyncClient
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest

@Service
class DispatcherService(
    private val amazonSqs: SqsAsyncClient,
    private val fcmService: FcmService,
    private val smsService: SmsService,
    private val mailService: MailService,
    private val jsonUtils: JsonUtils
) {
    private final val QUEUE_URL = System.getenv("SQS_URL")

    @Scheduled(fixedRate = 5000) // 5 seconds
    fun receiveMessages() {
        val receiveMessageRequest = ReceiveMessageRequest.builder()
            .queueUrl(QUEUE_URL)
            .maxNumberOfMessages(10)
            .messageAttributeNames(
                "channel",
            )
            .build()

        val messages = amazonSqs.receiveMessage(receiveMessageRequest).get().messages()

        for (message in messages) {
            val messageBodyJson = message.body()
            val attributes = message.messageAttributes()

            val messageBody = jsonUtils.fromJson(messageBodyJson, Map::class.java)
            val messageChannel = attributes["channel"]?.stringValue()

            println("Message received: $messageBody")
            println("Message channel: $messageChannel")

            when (messageChannel) {
                "fcm" -> {
                    fcmService.sendNotificationToToken(
                        messageBody["fcmToken"] as String,
                        messageBody["title"] as String,
                        messageBody["body"] as String,
                        jsonUtils.fromJson(messageBody["action"] as String, Map::class.java) as Map<String, String>,
                        messageBody["notificationId"] as String
                    )
                }

                "sms" -> {
                    smsService.sendSms(
                        messageBody["toNumber"] as String,
                        messageBody["message"] as String,
                        messageBody["notificationId"] as String
                    )
                }

                "mail" -> {
                    mailService.sendEmail(
                        messageBody["toEmail"] as String,
                        messageBody["subject"] as String,
                        messageBody["body"] as String,
                        messageBody["notificationId"] as String
                    )
                }
            }


            deleteMessage(message.receiptHandle())
        }
    }

    fun deleteMessage(messageReceiptHandle: String) {
        val deleteMessageRequest = DeleteMessageRequest.builder()
            .queueUrl(QUEUE_URL)
            .receiptHandle(messageReceiptHandle)
            .build()

        amazonSqs.deleteMessage(deleteMessageRequest)
    }
}