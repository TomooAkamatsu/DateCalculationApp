package com.example.demo.validation;

import com.example.demo.repository.UserMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserMapper userMapper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userMapper.findByUsername(value).isEmpty();
    }
}
