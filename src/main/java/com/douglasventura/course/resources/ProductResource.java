package com.douglasventura.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglasventura.course.entities.Product;
import com.douglasventura.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  @Autowired
  private ProductService userService;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> users = userService.findAll();
    return ResponseEntity.ok().body(users);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product user = userService.findById(id);
    return ResponseEntity.ok().body(user);
  }

}
