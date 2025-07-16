package com.delsocorro.openfeignproductservice;

import java.math.BigDecimal;

public record ProductDTO(Long productId, BigDecimal price, int quantity) {}
