package org.hw28.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hw28.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import static org.hw28.constant.ApiConstant.ADMIN_PAGE;
import static org.hw28.constant.ApiConstant.USER_PAGE;

@RestController
@RequiredArgsConstructor
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    private final UserService userService;

    @GetMapping(USER_PAGE + "/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable(required = false) Long id) {
        log.info("Getting user by id: {}", id);
        return userService.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(ADMIN_PAGE + "/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllUser() {
        log.info("Getting all users");
        return ResponseEntity.ok().body(userService.findAll());
    }
}
