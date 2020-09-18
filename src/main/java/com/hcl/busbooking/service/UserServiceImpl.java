package com.hcl.busbooking.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	private User user = new User();
	private ResponseMessage responseMessage=new ResponseMessage();
	@Override
	public ResponseMessage registration(UserDto userDto) {
		BeanUtils.copyProperties(userDto, user);
		//responseMessage.setMessage("Registration done!");
		user= userRepository.saveAndFlush(user);
		BeanUtils.copyProperties(responseMessage, user);
		return responseMessage;
		
	}


	@Override
	public List<Booking> myBookings(int userId) {
	User user=userRepository.getOne(userId);
	return user.getBookings();
	}
	

}
