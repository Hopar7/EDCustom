package com.ho.edcustom.service;

import com.ho.edcustom.entity.User;
import com.ho.edcustom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void createUser(String userid,String password){
        userRepository.save(User.builder()
                .userid(userid)
                .password(password)
                .build());
    }
}
