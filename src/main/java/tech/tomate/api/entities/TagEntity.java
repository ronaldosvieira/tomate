package tech.tomate.api.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import tech.tomate.api.resources.Tag;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    private Integer id;

    @Generated(GenerationTime.INSERT)
    private UUID hash;

    private String name;

    @Generated(GenerationTime.INSERT)
    private ZonedDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getHash() {
        return hash;
    }

    public void setHash(UUID hash) {
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Tag toResource() {
        Tag tag = new Tag();

        tag.setHash(getHash());
        tag.setName(getName());
        tag.setCreatedAt(getCreatedAt());

        return tag;
    }

    public static TagEntity fromResource(Tag tag) {
        TagEntity tagEntity = new TagEntity();

        tagEntity.setHash(tag.getHash());
        tagEntity.setName(tag.getName());
        tagEntity.setCreatedAt(tag.getCreatedAt());

        return tagEntity;
    }
}
