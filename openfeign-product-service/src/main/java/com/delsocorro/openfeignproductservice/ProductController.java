package com.delsocorro.openfeignproductservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/{id}/verification")
    public ProductDTO getProductById(@PathVariable("id") Long id) {
        return new ProductDTO(id, new BigDecimal("3452.45"), 45);
    }
}
