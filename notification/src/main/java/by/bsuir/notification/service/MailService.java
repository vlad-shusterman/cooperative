package by.bsuir.notification.service;

import by.bsuir.notification.entity.IncomingMail;
import by.bsuir.notification.entity.OutgoingMail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MailService {
    OutgoingMail processMail(OutgoingMail mail);

    Page<OutgoingMail> getAllOutgoing(Pageable pageable);

    Page<IncomingMail> getAllIncoming(Pageable pageable);
}
