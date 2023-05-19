package com.devsuperior.user.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.user.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//public List<User> findByName();

}
