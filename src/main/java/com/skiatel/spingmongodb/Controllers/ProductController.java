package com.skiatel.spingmongodb.Controllers;

import com.skiatel.spingmongodb.DAO.Product;
import com.skiatel.spingmongodb.Repository.ProductRepository;
import com.skiatel.spingmongodb.request.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(productRequest.getCategory());

        try{
            productRepository.insert(product);
            return ResponseEntity.ok("Producto Creado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al crear el producto " + e.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        if(productRepository.findAll().isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        if(productRepository.findById(id).isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest){
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.badRequest().body("Producto no encontrado");
        }

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(productRequest.getCategory());

        try{
            productRepository.save(product);
            return ResponseEntity.ok("Producto Actualizado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al actualizar el producto " + e.getMessage());
        }
    }
}
