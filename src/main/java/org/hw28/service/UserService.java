package org.hw28.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hw28.entity.UserEntity;
import org.hw28.repository.UserRepository;
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

    public Optional<UserEntity> findById(Long id){
        log.info("get user by id: {}", id);
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll() {
        log.info("get all user");
        return userRepository.findAll();
    }
}

