package by.bsuir.notification.service;

import by.bsuir.notification.entity.OutgoingMail;
import by.bsuir.notification.entity.enums.SendingType;
import by.bsuir.notification.repository.OutgoingMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Date;

@Service
public class MailService {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private OutgoingMailRepository mailRepository;

    public OutgoingMail processMail(OutgoingMail mail) {
        Date date = new Date();
        if(mail.getSendingType() == SendingType.EMAIL) {
            mail.setSendingDate(date);
            try {
                notificationService.sendEmail(mail);
            } catch (MessagingException ex) {
                throw new MailSendException("Cannot send email", ex.getCause());
            }
        } else {
            createSimpleMail(mail);
        }
        mailRepository.save(mail);

        return mail;
    }

    public void createSimpleMail(OutgoingMail mail) {
        
    }
}
