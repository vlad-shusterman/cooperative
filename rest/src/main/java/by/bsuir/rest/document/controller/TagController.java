package by.bsuir.rest.document.controller;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.service.tag.TagManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/tag")
public class TagController {
    private TagManager tagManager;

    @GetMapping
    public ResponseEntity<List<Tag>> getAll() {
        return ResponseEntity.ok(tagManager.findAll());
    }
}
