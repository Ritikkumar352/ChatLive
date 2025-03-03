package com.chat.chatLive.repo;

import com.chat.chatLive.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel,Integer> {

}
