package com.douglasventura.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasventura.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
