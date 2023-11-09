package de.tt.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.tt.persistence.entity.ProjectEntity;

/**
 * Project Repository class
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query("SELECT e FROM ProjectEntity e WHERE NOT EXISTS (SELECT r FROM e.timeTrack r)")
    public List<ProjectEntity> findAllWithoutTimetrack();

    @Query("SELECT e FROM ProjectEntity e WHERE NOT EXISTS (SELECT r FROM e.timeTrack r WHERE r.id <> ?1)")
    public List<ProjectEntity> findAllWithoutOtherTimetrack(Long id);

}
