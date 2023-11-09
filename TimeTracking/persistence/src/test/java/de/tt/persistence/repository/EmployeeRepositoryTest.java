package de.tt.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.tt.persistence.entity.EmployeeEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for EmployeeRepository
 */
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testFindAll() {
        List<EmployeeEntity> employees = repository.findAll();
        assertTrue(employees.isEmpty());
    }
}
