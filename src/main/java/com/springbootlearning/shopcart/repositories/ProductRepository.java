package com.springbootlearning.shopcart.repositories;

import org.springframework.stereotype.Repository;

import com.springbootlearning.shopcart.models.Product;

import org.springframework.data.jpa.repository.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
