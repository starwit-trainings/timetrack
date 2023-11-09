package de.tt.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.tt.persistence.entity.TimeTrackEntity;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Tests for TimeTrackRepository
 */
@DataJpaTest
public class TimeTrackRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TimeTrackRepository repository;

    @Test
    public void testFindAll() {
        List<TimeTrackEntity> timetracks = repository.findAll();
        assertTrue(timetracks.isEmpty());
    }
}
