package tech.tomate.api.resources;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Tag {

    private UUID hash;
    private String name;
    private ZonedDateTime createdAt;

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
}
