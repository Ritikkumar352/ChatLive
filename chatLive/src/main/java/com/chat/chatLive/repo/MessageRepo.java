package com.chat.chatLive.repo;

import com.chat.chatLive.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepo extends JpaRepository<MessageModel, UUID> {

}
