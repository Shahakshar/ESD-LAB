package com.akshar.restobistro.repo;

import com.akshar.restobistro.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p where p.price > ?1 and p.price < ?2 order by p.price DESC limit 2")
    List<Product> findAllProducts(double p1, double p2);
}
