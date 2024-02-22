package org.hw28.repository;

import org.hw28.entity.UserEntity;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository extends Repository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAll();

}
