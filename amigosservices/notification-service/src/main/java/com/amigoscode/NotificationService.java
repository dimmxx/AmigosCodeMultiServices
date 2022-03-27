package com.amigoscode;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.clients.notification.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationResponse sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
            .customerId(request.customerId())
            .firstName(request.firstName())
            .lastName(request.lastName())
            .isFraudster(request.isFraudster())
            .email(request.email())
            .message("Hello! ....")
            .build();
        notification = notificationRepository.save(notification);

        if (notification.getId() != null) {
            return new NotificationResponse(notification.getId(), notification.getCustomerId(), true);
        } else {
            return new NotificationResponse(notification.getId(), notification.getCustomerId(), false);
        }
    }
}
