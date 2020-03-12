package by.bsuir.notification.service.impl;

import by.bsuir.notification.entity.Mail;
import by.bsuir.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class GmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Mail mail) throws MessagingException {
        String[] to = mail.getReceivers().toArray(String[]::new);
        String subject = mail.getSubject();
        String text = mail.getText();
        boolean isHtml = mail.isHtml();
        Optional<List<File>> attachments = Optional.ofNullable(mail.getAttachments());
        boolean multipart = attachments.isPresent();

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, multipart);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, isHtml);

        if(attachments.isPresent()) {
            for (File attachment : attachments.get()) {
                FileSystemResource file = new FileSystemResource(attachment);
                String fileName = attachment.getName();
                helper.addAttachment(fileName, file);
            }
        }

        javaMailSender.send(msg);
    }
}
