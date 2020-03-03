package by.bsuir.rest.notification.controller;

import by.bsuir.notification.repository.BroadcastMailRepository;
import by.bsuir.notification.repository.IncomingMailRepository;
import by.bsuir.notification.repository.OutgoingMailRepository;
import by.bsuir.rest.notification.mapper.OutgoingMailMapper;
import by.bsuir.rest.notification.model.OutgoingMailDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/notifications")
public class OutgoingEmailController {

    private final OutgoingMailMapper outgoingMailMapper;
    private final OutgoingMailRepository outgoingMailRepository;
    private final IncomingMailRepository incomingMailRepository;
    private final BroadcastMailRepository broadcastMailRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutgoingMailDto> sendMail(@RequestBody OutgoingMailDto mailDto) {
        var entityToSave = outgoingMailMapper.fromDto(mailDto);
        outgoingMailRepository.save(entityToSave);

        return ResponseEntity.ok(mailDto);
    }

}
