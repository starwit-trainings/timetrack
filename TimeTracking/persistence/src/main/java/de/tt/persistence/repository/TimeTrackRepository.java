package de.tt.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.tt.persistence.entity.TimeTrackEntity;

/**
 * TimeTrack Repository class
 */
@Repository
public interface TimeTrackRepository extends JpaRepository<TimeTrackEntity, Long> {

}
