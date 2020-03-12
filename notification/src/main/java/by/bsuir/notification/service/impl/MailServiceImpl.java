package by.bsuir.notification.service.impl;

import by.bsuir.notification.entity.IncomingMail;
import by.bsuir.notification.entity.OutgoingMail;
import by.bsuir.notification.entity.enums.SendingType;
import by.bsuir.notification.repository.IncomingMailRepository;
import by.bsuir.notification.repository.OutgoingMailRepository;
import by.bsuir.notification.service.MailService;
import by.bsuir.notification.service.NotificationService;
import by.bsuir.notification.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private OutgoingMailRepository outgoingMailRepository;
    @Autowired
    private IncomingMailRepository incomingMailRepository;
    @Autowired
    private SimpleMailService simpleMailService;

    @Override
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
            simpleMailService.createSimpleMail(mail);
        }
        outgoingMailRepository.save(mail);

        return mail;
    }

    @Override
    public Page<OutgoingMail> getAllOutgoing(Pageable pageable) {
        return outgoingMailRepository.findAll(pageable);
    }

    @Override
    public Page<IncomingMail> getAllIncoming(Pageable pageable) {
        return incomingMailRepository.findAll(pageable);
    }
}
