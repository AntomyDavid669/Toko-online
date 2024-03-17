package com.projectbaru.TokoOnline.service;

import com.projectbaru.TokoOnline.dto.UserDto;
import com.projectbaru.TokoOnline.entity.User;

public interface UserService {
    User save(UserDto userDto);
}
