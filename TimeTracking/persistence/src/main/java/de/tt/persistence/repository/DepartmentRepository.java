package de.tt.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.tt.persistence.entity.DepartmentEntity;

/**
 * Department Repository class
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
