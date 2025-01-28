package com.security.app.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class FirebaseConfig {

    @Bean
    fun firebaseApp(): FirebaseApp {
        val base64Credentials = System.getenv("FIREBASE_SERVICE_ACCOUNT")
            ?: throw IllegalArgumentException("FIREBASE_SERVICE_ACCOUNT is not set")

        val decodedCredentials = Base64.getDecoder().decode(base64Credentials)

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(decodedCredentials.inputStream()))
            .build()

        return FirebaseApp.initializeApp(options)
    }
}