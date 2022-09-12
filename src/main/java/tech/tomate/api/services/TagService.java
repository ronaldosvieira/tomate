package tech.tomate.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tomate.api.entities.TagEntity;
import tech.tomate.api.repositories.TagRepository;
import tech.tomate.api.resources.Tag;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(@Autowired TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> retrieveTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagEntity::toResource)
                .collect(Collectors.toList());
    }

    public Tag createTag(Tag tag) {
        boolean isNameAlreadyTaken = tagRepository.findByName(tag.getName()).isPresent();

        if (isNameAlreadyTaken) {
            throw new IllegalArgumentException("A tag with the specified name already exists");
        }

        return tagRepository.save(TagEntity.fromResource(tag)).toResource();
    }

    public Tag retrieveTagByHash(UUID hash) {
        return tagRepository.findByHash(hash).orElseThrow().toResource();
    }

    public void removeTagByHash(UUID hash) {
        tagRepository.removeByHash(hash).orElseThrow();
    }
}
