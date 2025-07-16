package com.delsocorro.openfeignorderservice;

import java.math.BigDecimal;

public record ProductVerificationDTO(Long productId, BigDecimal price, int quantity) {
}
