package com.amigoscode.customer;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.clients.notification.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository,
                              NotificationClient notificationClient,
                              FraudClient fraudClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
        customer = customerRepository.saveAndFlush(customer);
        FraudCheckResponse checkResponse = fraudClient.isFraudster(customer.getId());
        if(checkResponse != null){
            NotificationResponse response = notificationClient.sendNotification(NotificationRequest.builder()
                .customerId(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .isFraudster(checkResponse.isFraudster())
                .email(customer.getEmail())
                .build());
            log.info("notification for customer id={} is sent={}, notification id={}", response.customerId(), response.isSent(), response.id());
            if (checkResponse.isFraudster()) {
                throw new IllegalStateException("fraudster");
            }
        } else {
            throw new RuntimeException("no connection with fraud service");
        }
    }
}
