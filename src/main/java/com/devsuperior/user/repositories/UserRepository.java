package com.devsuperior.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
