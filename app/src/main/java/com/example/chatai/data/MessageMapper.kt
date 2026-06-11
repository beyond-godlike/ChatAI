package com.example.chatai.data

fun MessageDto.toDomain(): Message {
    return Message(
        text = text,
        sender = when(sender) {
            "user" -> Sender.USER
            else -> Sender.ASSISTANT
        },
        timestamp = timestamp
    )
}

fun Message.toDto(): MessageDto {
    return MessageDto(
        text = text,
        sender = when(sender) {
            Sender.USER -> "user"
            Sender.ASSISTANT -> "assistant"
        },
        timestamp = timestamp
    )
}