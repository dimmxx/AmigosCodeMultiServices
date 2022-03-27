package com.amigoscode.clients.notification;

import lombok.Builder;

@Builder
public record NotificationResponse(Integer id, Integer customerId, Boolean isSent) {
}
