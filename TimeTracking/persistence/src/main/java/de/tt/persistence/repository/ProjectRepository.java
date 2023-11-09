package de.tt.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.tt.persistence.entity.ProjectEntity;

/**
 * Project Repository class
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
