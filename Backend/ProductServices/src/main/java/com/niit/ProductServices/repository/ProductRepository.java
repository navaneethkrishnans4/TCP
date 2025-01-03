package com.niit.ProductServices.repository;
import com.niit.ProductServices.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}