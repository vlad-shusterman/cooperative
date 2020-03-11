package by.bsuir.notification.service;

import by.bsuir.notification.entity.Mail;

import javax.mail.MessagingException;

public interface NotificationService {
    void sendEmail(Mail mail) throws MessagingException;
}
