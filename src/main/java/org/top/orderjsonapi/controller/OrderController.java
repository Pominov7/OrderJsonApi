package org.top.orderjsonapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.top.orderjsonapi.db.entity.Order;
import org.top.orderjsonapi.db.repository.OrderRepository;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/ping")
    public @ResponseBody String ping() {
        return "pong";
    }

    // CREATE
    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrder(@RequestParam String name, @RequestParam(name = "date", required = false) String strDate) {
        Order order = new Order();
        order.setNameClient(name);
        order.setDate(LocalDate.parse(strDate));
        orderRepository.save(order);
        return "Saved";
    }

    // READ
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    // UPDATE
    @PutMapping(path = "/update")
    public @ResponseBody String updateOrder(@RequestBody Order orderTEntity) {
        Optional<Order> orderDb = orderRepository.findById(orderTEntity.getIdF());
        if (orderDb.isPresent()) {
            Order order = orderDb.get();
            if (orderTEntity.getNameClient() != null) {
                order.setNameClient(orderTEntity.getNameClient());
            }
            if (orderTEntity.getDate() != null) {
                order.setDate(orderTEntity.getDate());
            }
            orderRepository.save(order);
        }
        return "Update";
    }

    // DELETE
    @PostMapping(path = "/remove")
    public @ResponseBody String removeOrder(@RequestParam Integer id) {
        Optional<Order> deleted = orderRepository.findById(id);
        if (deleted.isPresent()) {
            orderRepository.delete(deleted.get());
            return "Order " + deleted.get() + " deleted";
        }
        return "Order with id " + id + " is not exists";
    }

}
