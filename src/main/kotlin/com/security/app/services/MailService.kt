package com.security.app.services

import com.security.app.model.NotificationStatus
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class MailService(
    private val javaMailSender: JavaMailSender,
    private val callbackService: CallbackService,
) {
    private final val from = System.getenv("MAIL_USERNAME")
    fun sendEmail(to: String, subject: String, content: String, notificationId: String) {
        try {
            val mimeMessage = javaMailSender.createMimeMessage()
            val helper = MimeMessageHelper(mimeMessage)

            helper.setFrom(from)
            helper.setTo(to)
            helper.setSubject(subject)
            helper.setText(content, true)

            javaMailSender.send(mimeMessage)
            callbackService.sendCallbackNotification(notificationId, "mail", NotificationStatus.SENT, null)
        } catch (e: Exception) {
            callbackService.sendCallbackNotification(notificationId, "mail", NotificationStatus.FAILED, null)
            e.printStackTrace()
        }
    }
}