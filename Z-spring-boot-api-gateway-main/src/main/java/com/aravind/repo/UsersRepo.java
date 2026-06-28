package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	public abstract Users findByUserName(String username);
}
