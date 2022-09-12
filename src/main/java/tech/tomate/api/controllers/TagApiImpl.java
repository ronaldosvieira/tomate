package tech.tomate.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.tomate.api.resources.Tag;
import tech.tomate.api.services.TagService;

import java.util.List;
import java.util.UUID;

@RestController
public class TagApiImpl implements TagApi {

    private final TagService tagService;

    public TagApiImpl(@Autowired TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public List<Tag> retrieveTags() {
        return tagService.retrieveTags();
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagService.createTag(tag);
    }

    @Override
    public Tag retrieveTag(UUID hash) {
        return tagService.retrieveTagByHash(hash);
    }

    @Override
    public Tag modifyTag(UUID hash, Tag tag) {
        return null;
    }

    @Override
    public void removeTag(UUID hash) {
        tagService.removeTagByHash(hash);
    }
}
