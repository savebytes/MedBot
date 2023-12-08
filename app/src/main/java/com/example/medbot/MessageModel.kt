package com.example.medbot



data class MessageModel(var message: String, var sentBy: String) {
    companion object {
        const val SENT_BY_ME = "me"
        const val SENT_BY_BOT = "bot"
    }
}