package by.bsuir.rest.notification.controller;

import by.bsuir.notification.entity.OutgoingMail;
import by.bsuir.notification.service.MailService;
import by.bsuir.rest.notification.mapper.IncomingMailMapper;
import by.bsuir.rest.notification.mapper.OutgoingMailMapper;
import by.bsuir.rest.notification.model.IncomingMailDto;
import by.bsuir.rest.notification.model.OutgoingMailDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping(value = "/api/notifications")
public class MailController {

    @Autowired
    private MailService mailService;
    @Autowired
    private OutgoingMailMapper outgoingMailMapper;
    @Autowired
    private IncomingMailMapper incomingMailMapper;

    @PostMapping("/send")
    public ResponseEntity<OutgoingMailDto> sendMail(@RequestBody OutgoingMailDto mailDto) {
        OutgoingMail outgoingMail = mailService.processMail(outgoingMailMapper.fromDto(mailDto));
        return ResponseEntity.ok(outgoingMailMapper.toDto(outgoingMail));
    }

    @GetMapping("/outgoing")
    public Page<OutgoingMailDto> getAllOutgoing(@PageableDefault(size = 15) Pageable pageable) {
        List<OutgoingMailDto> mails = mailService.getAllOutgoing(pageable)
                .stream()
                .map(outgoingMailMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(mails);
    }

    @GetMapping("/incoming")
    public Page<IncomingMailDto> getAllIncoming(@PageableDefault(size = 15) Pageable pageable) {
        List<IncomingMailDto> mails = mailService.getAllIncoming(pageable)
                .stream()
                .map(incomingMailMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(mails);
    }
}
