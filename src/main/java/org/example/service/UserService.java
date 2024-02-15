package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findById(Long id){
        log.info("get user by id: {}", id);
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        log.info("get all user");
        return userRepository.findAll();
    }

    public User save(User user) {
        log.info("save user : {}", user);
        return userRepository.save(user);
    }

    @Transactional
    public void updateUserById(Long recordId, User user) {
        log.info("update user by id: {}", recordId);
        userRepository.updateUserById(recordId, user);
    }

    @Transactional
    public void deleteRecordById(Long id) {
        log.info("delete user by id: {}", id);
        userRepository.deleteRecordById(id);
    }
}
