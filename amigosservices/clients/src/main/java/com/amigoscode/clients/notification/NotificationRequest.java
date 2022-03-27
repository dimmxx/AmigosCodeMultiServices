package com.amigoscode.clients.notification;

import lombok.Builder;

public record NotificationRequest(
    Integer customerId,
    String firstName,
    String lastName,
    String email,
    Boolean isFraudster
    ) {

    @Builder
    public NotificationRequest {
    }
}
