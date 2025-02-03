package com.security.app.model

enum class Language(val value: String) {
    VIETNAMESE("VIETNAMESE"),
    ENGLISH("ENGLISH"),
    FRENCH("FRENCH");

    companion object {
        fun fromString(value: String): Language {
            return when (value) {
                "VIETNAMESE" -> VIETNAMESE
                "ENGLISH" -> ENGLISH
                "FRENCH" -> FRENCH
                else -> throw IllegalArgumentException("Language not found")
            }
        }
    }
}

enum class LanguageLevel(val value: String) {
    A1("A1"),
    A2("A2"),
    B1("B1"),
    B2("B2"),
    C1("C1"),
    C2("C2");

    companion object {
        fun fromString(value: String): LanguageLevel {
            return when (value) {
                "A1" -> A1
                "A2" -> A2
                "B1" -> B1
                "B2" -> B2
                "C1" -> C1
                "C2" -> C2
                else -> throw IllegalArgumentException("Language level not found")
            }
        }
    }
}

enum class LearningType(val value: String) {
    VOCABULARY("VOCABULARY"),
    GRAMMAR("GRAMMAR"),
    LISTENING("LISTENING"),
    SPEAKING("SPEAKING"),
    READING("READING"),
    WRITING("WRITING");

    companion object {
        fun fromString(value: String): LearningType {
            return when (value) {
                "VOCABULARY" -> VOCABULARY
                "GRAMMAR" -> GRAMMAR
                "LISTENING" -> LISTENING
                "SPEAKING" -> SPEAKING
                "READING" -> READING
                "WRITING" -> WRITING
                else -> throw IllegalArgumentException("Learning type not found")
            }
        }
    }
}

enum class LearningContentType(val value: String) {
    WORD("WORD"),
    EXPRESSION("EXPRESSION"),
    IDIOM("IDIOM"),
    SENTENCE("SENTENCE"),
    PHRASAL_VERB("PHRASAL_VERB"),
    TENSE("TENSE"),
    PHONETICS("PHONETICS");

    companion object {
        fun fromString(value: String): LearningContentType {
            return when (value) {
                "WORD" -> WORD
                "EXPRESSION" -> EXPRESSION
                "IDIOM" -> IDIOM
                "SENTENCE" -> SENTENCE
                "PHRASAL_VERB" -> PHRASAL_VERB
                "TENSE" -> TENSE
                "PHONETICS" -> PHONETICS
                else -> throw IllegalArgumentException("Learning content type not found")
            }
        }
    }
}

enum class WordType(val value: String) {
    NOUN("NOUN"),
    VERB("VERB"),
    ADJECTIVE("ADJECTIVE"),
    ADVERB("ADVERB"),
    PRONOUN("PRONOUN"),
    PREPOSITION("PREPOSITION"),
    CONJUNCTION("CONJUNCTION"),
    INTERJECTION("INTERJECTION");

    companion object {
        fun fromString(value: String): WordType {
            return when (value) {
                "NOUN" -> NOUN
                "VERB" -> VERB
                "ADJECTIVE" -> ADJECTIVE
                "ADVERB" -> ADVERB
                "PRONOUN" -> PRONOUN
                "PREPOSITION" -> PREPOSITION
                "CONJUNCTION" -> CONJUNCTION
                "INTERJECTION" -> INTERJECTION
                else -> throw IllegalArgumentException("Word type not found")
            }
        }
    }
}

enum class NotificationStatus(val value: String) {
    PENDING("PENDING"),
    SENT("SENT"),
    FAILED("FAILED");

    companion object {
        fun fromString(value: String): NotificationStatus {
            return when (value) {
                "PENDING" -> PENDING
                "SENT" -> SENT
                "FAILED" -> FAILED
                else -> throw IllegalArgumentException("Notification status not found")
            }
        }
    }
}