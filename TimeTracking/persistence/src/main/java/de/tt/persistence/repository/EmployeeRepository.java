package de.tt.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.tt.persistence.entity.EmployeeEntity;

/**
 * Employee Repository class
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE NOT EXISTS (SELECT r FROM e.department r)")
    public List<EmployeeEntity> findAllWithoutDepartment();

    @Query("SELECT e FROM EmployeeEntity e WHERE NOT EXISTS (SELECT r FROM e.department r WHERE r.id <> ?1)")
    public List<EmployeeEntity> findAllWithoutOtherDepartment(Long id);

    @Query("SELECT e FROM EmployeeEntity e WHERE NOT EXISTS (SELECT r FROM e.employeeTimeTrack r)")
    public List<EmployeeEntity> findAllWithoutTimetrack();

    @Query("SELECT e FROM EmployeeEntity e WHERE NOT EXISTS (SELECT r FROM e.employeeTimeTrack r WHERE r.id <> ?1)")
    public List<EmployeeEntity> findAllWithoutOtherTimetrack(Long id);

}
