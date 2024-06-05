package com.test.CouponCraze.Controller;

import com.test.CouponCraze.Service.ProductService;
import com.test.CouponCraze.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @PostMapping("/addProducts")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}