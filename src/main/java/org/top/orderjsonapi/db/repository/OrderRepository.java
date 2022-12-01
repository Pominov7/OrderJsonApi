package org.top.orderjsonapi.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.orderjsonapi.db.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
