package org.top.orderjsonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.top.orderjsonapi.db.entity.Product;
import org.top.orderjsonapi.db.repository.ProductRepository;

import java.util.Optional;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/ping")
    public @ResponseBody String ping() {
        return "pong";
    }


    // CREATE
    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrder(@RequestParam String nameProduct, @RequestParam Double price
            , @RequestParam String onOffSale) {
        Product product = new Product();
        product.setNameProduct(nameProduct);
        product.setPrice(price);
        product.setOnOffSale(onOffSale);
        productRepository.save(product);
        return "Saved";
    }

    // READ
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // UPDATE
    @PutMapping(path = "/update")
    public @ResponseBody String updateProduct(@RequestBody Product productEntity) {
        Optional<Product> productDb = productRepository.findById(productEntity.getIdF());
        if (productDb.isPresent()) {
            Product product = productDb.get();
            if (product.getNameProduct() != null) {
                product.setNameProduct(productEntity.getNameProduct());
            }
            if (product.getPrice() != null) {
                product.setPrice(productEntity.getPrice());
            }
            if (product.getOnOffSale() != null) {
                product.setOnOffSale(productEntity.getOnOffSale());
            }

            productRepository.save(product);
        }
        return "Update";
    }

    // DELETE
    @PostMapping(path = "/remove")
    public @ResponseBody String removeProduct(@RequestParam Integer id) {
        Optional<Product> deleted = productRepository.findById(id);
        if (deleted.isPresent()) {
            productRepository.delete(deleted.get());
            return "Product " + deleted.get() + " deleted";
        }
        return "Product with id " + id + " is not exists";
    }

}
