package tech.tomate.api.controllers;

import org.springframework.web.bind.annotation.*;
import tech.tomate.api.resources.Tag;

import java.util.List;
import java.util.UUID;

@RestController
public interface TagApi {

    @GetMapping("/tags")
    List<Tag> retrieveTags();

    @PostMapping("/tags")
    Tag createTag();

    @GetMapping("/tags/{hash}")
    Tag retrieveTag(@PathVariable UUID hash);

    @PatchMapping("/tags/{hash}")
    Tag modifyTag(@PathVariable UUID hash);

    @DeleteMapping("/tags/{hash}")
    Tag removeTag(@PathVariable UUID hash);
}
