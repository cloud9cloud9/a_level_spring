package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {

    /**
     * Retrieve a user by their ID
     *
     * @param id the ID of the user to retrieve
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<User> findById(Long id);

    /**
     * Saves the user entity to the database.
     *
     * @param entity the user entity to be saved
     * @return the saved user entity
     */

    User save(User entity);

    /**
     * Retrieves all users from the database.
     * @return a list of User objects representing all users
     */
    List<User> findAll();

    /**
     * Updates a user entity by its ID.
     *
     * @param recordId The ID of the user entity to update
     * @param user The updated user entity
     */
    @Modifying
    @Query("UPDATE User u SET u.username = :#{#user.username}, u.email = :#{#user.email}, u.password = :#{#user.password} WHERE u.id = :recordId")
    void updateUserById(@Param("recordId") Long recordId, @Param("user") User user);

    /**
     * Deletes a record by its ID
     *
     * @param recordId the ID of the record to be deleted
     */
    void deleteRecordById(Long recordId);
}
