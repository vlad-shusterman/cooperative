package by.bsuir.rest.notification.controller;

import by.bsuir.notification.entity.OutgoingMail;
import by.bsuir.notification.service.MailService;
import by.bsuir.rest.notification.mapper.OutgoingMailMapper;
import by.bsuir.rest.notification.model.OutgoingMailDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/api/notifications")
public class SendingController {

    @Autowired
    private MailService mailService;
    @Autowired
    private OutgoingMailMapper mailMapper;

    @PostMapping("/send")
    public ResponseEntity<OutgoingMailDto> sendMail(@RequestBody OutgoingMailDto mailDto) {
        OutgoingMail outgoingMail = mailService.processMail(mailMapper.fromDto(mailDto));
        return ResponseEntity.ok(mailMapper.toDto(outgoingMail));
    }
}
