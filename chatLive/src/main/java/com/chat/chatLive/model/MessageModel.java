package com.chat.chatLive.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.UUID)
    private UUID id;

    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private UUID sender;
    @Column(nullable = false)
    private UUID receiver;
    // Store message Date adn time
    @Column(nullable = false)
    private LocalDateTime timestamp=LocalDateTime.now();

    // Read these 2 annotations
//    @PreUpdate
//    @PrePersist
//    protected void onCreate() {
//        timestamp = LocalDateTime.now();
//    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public void setReceiver(UUID receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "receiver=" + receiver +
                ", timestamp=" + timestamp +
                ", sender=" + sender +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
