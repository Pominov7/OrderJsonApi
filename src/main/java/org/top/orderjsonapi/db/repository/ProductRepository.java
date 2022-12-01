package org.top.orderjsonapi.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.orderjsonapi.db.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
