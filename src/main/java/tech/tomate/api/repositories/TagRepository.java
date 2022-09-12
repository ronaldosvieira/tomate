package tech.tomate.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.tomate.api.entities.TagEntity;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    Optional<TagEntity> findByHash(UUID hash);
    Optional<TagEntity> findByName(String name);
    @Transactional Optional<TagEntity> removeByHash(UUID hash);
}
