package com.delsocorro.openfeignorderservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/{product_id}/availability")
    public ResponseEntity<ProductVerificationDTO> getAvailability(@PathVariable("product_id") Long productId) {
        return ResponseEntity.ok(productClient.getProductVerfication(productId));
    }
}
