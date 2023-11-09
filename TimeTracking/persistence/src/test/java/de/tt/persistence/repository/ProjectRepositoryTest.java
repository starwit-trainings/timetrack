package de.tt.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.tt.persistence.entity.ProjectEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for ProjectRepository
 */
@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository repository;

    @Test
    public void testFindAll() {
        List<ProjectEntity> projects = repository.findAll();
        assertTrue(projects.isEmpty());
    }
}
