package com.example.demo.service;

import com.example.demo.config.PasswordEncoderConfig;
import com.example.demo.domain.User;
import com.example.demo.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public void create(String username, String password, String authority) {
        var encodedPassword = passwordEncoder.encode(password);
        userMapper.insert(username, encodedPassword, authority);
    }
}
