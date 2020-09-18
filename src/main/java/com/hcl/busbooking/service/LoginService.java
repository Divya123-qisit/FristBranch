package com.hcl.busbooking.service;

import com.hcl.busbooking.dto.UsersDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.model.User;

public interface LoginService {
 public User login(UsersDto usersDto) throws UserNotFoundException;
}
