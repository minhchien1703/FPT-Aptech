package com.example.class5api.controller;

import com.example.class5api.model.Product;
import com.example.class5api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
//        service.saveProduct(product);
//
//        Optional<Product> createdProduct = service.getProductById( product.getId() );
//
//        if (createdProduct == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(createdProduct.get());
//        }
//    }


    // Get all products
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.fetchAllProducts();
        return ResponseEntity.ok(products);
    }

    // Create a new product
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping(path = "/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> updatedProductOptional = productService.updateProduct(id, product);
        return updatedProductOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Delte a product
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean deletionStatus = productService.deleteProduct(id);
        if (deletionStatus) {
            return ResponseEntity.ok("Product with ID " + id + " has been deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product with ID " + id);
        }
    }

}