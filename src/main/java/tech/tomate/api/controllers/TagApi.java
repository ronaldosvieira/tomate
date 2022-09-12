package tech.tomate.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.tomate.api.resources.Tag;

import java.util.List;
import java.util.UUID;

@RestController
public interface TagApi {

    @GetMapping("/tags")
    List<Tag> retrieveTags();

    @PostMapping("/tags")
    Tag createTag(@RequestBody Tag tag);

    @GetMapping("/tags/{hash}")
    Tag retrieveTag(@PathVariable UUID hash);

    @PatchMapping("/tags/{hash}")
    Tag modifyTag(@PathVariable UUID hash, @RequestBody Tag tag);

    @DeleteMapping("/tags/{hash}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeTag(@PathVariable UUID hash);
}
