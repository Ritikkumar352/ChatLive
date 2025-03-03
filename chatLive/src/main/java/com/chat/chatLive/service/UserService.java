package com.chat.chatLive.service;

import com.chat.chatLive.model.UserModel;
import com.chat.chatLive.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    // * put user Details in Response
    public Map<String, String> addUserDetails(UserModel foundUser) {
        Map<String, String> response = new HashMap<>();
        response.put("message","User Found");
        response.put("username", foundUser.getUsername());
        response.put("firstName", foundUser.getFirstName());
        response.put("lastName", foundUser.getLastName());
        response.put("phone", foundUser.getPhone());
        return response;
    }

    public ResponseEntity<Map<String, String>> fetchUser(UserModel user) {
        UserModel foundUser = userRepo.findById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User not found -- [User Service"));
        // will add User Details only after foundUser is not else, else will throw Error
        Map<String, String> response = new HashMap<>(addUserDetails(foundUser));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, String>> deleteUser(int id, UserModel user) {
        Map<String, String> response = new HashMap<>(addUserDetails(user));
        UserModel foundUser = userRepo.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                "User not found-- [User service -deleteUser]"));

        userRepo.deleteById(id);
        response.put("message","User Deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
