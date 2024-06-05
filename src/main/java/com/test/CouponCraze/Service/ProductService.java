package com.test.CouponCraze.Service;

import com.test.CouponCraze.model.Product;
import com.test.CouponCraze.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
