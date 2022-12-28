package com.douglasventura.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasventura.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
