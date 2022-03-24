package com.amigoscode;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}
