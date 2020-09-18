package com.hcl.busbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.busbooking.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmailAndPassword(String email, String password);
	public User findByUserId(int userId);

}
