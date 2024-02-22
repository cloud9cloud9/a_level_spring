package org.hw28.security;

import lombok.RequiredArgsConstructor;
import org.hw28.entity.UserEntity;
import org.hw28.repository.UserRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
        return UserPrincipal.builder()
                .userId(user.get().getId())
                .userName(user.get().getUsername())
                .password(user.get().getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(String.valueOf(user.get().getUserRole()))))
                .build();
    }
}
