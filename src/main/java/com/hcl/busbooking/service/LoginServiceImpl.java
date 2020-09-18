package com.hcl.busbooking.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.UsersDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.model.User;


@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserRepository loginRepository;
	private User user = new User();
	@Override
	public User login(UsersDto userDto) throws UserNotFoundException {
		
		BeanUtils.copyProperties(userDto, user);

		User login = loginRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (login == null) {
			throw new UserNotFoundException("plase enter user name and password");
		}
		
		return login;
	}
}


