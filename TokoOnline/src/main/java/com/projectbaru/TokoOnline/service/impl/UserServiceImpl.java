package com.projectbaru.TokoOnline.service.impl;

import com.projectbaru.TokoOnline.dto.UserDto;
import com.projectbaru.TokoOnline.entity.User;
import com.projectbaru.TokoOnline.repository.UserRepository;
import com.projectbaru.TokoOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFullname(), userDto.getAlamat(), userDto.getTelepon());
        return userRepository.save(user);
    }
}
