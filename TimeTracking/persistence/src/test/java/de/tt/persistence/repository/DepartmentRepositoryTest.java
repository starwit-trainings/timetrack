package de.tt.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.tt.persistence.entity.DepartmentEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for DepartmentRepository
 */
@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartmentRepository repository;

    @Test
    public void testFindAll() {
        List<DepartmentEntity> departments = repository.findAll();
        assertTrue(departments.isEmpty());
    }
}
