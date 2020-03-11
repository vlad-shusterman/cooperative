package by.bsuir.notification.service;

import by.bsuir.notification.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

public class GmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Mail mail) throws MessagingException {
        String[] to = mail.getTo().toArray(String[]::new);
        String subject = mail.getSubject();
        String text = mail.getText();
        boolean isHtml = mail.isHtml();
        List<File> attachments = mail.getAttachments();
        boolean multipart = !attachments.isEmpty();

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, multipart);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, isHtml);

        for (File attachment: attachments){
            FileSystemResource file = new FileSystemResource(attachment);
            String fileName = attachment.getName();
            helper.addAttachment(fileName, file);
        }

        javaMailSender.send(msg);
    }
}
