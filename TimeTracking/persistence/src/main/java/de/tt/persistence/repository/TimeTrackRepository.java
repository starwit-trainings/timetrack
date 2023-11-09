package de.tt.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.tt.persistence.entity.TimeTrackEntity;

/**
 * TimeTrack Repository class
 */
@Repository
public interface TimeTrackRepository extends JpaRepository<TimeTrackEntity, Long> {

    @Query("SELECT e FROM TimeTrackEntity e WHERE NOT EXISTS (SELECT r FROM e.project r)")
    public List<TimeTrackEntity> findAllWithoutProject();

    @Query("SELECT e FROM TimeTrackEntity e WHERE NOT EXISTS (SELECT r FROM e.project r WHERE r.id <> ?1)")
    public List<TimeTrackEntity> findAllWithoutOtherProject(Long id);
    @Query("SELECT e FROM TimeTrackEntity e WHERE NOT EXISTS (SELECT r FROM e.myTimetrack r)")
    public List<TimeTrackEntity> findAllWithoutMyTimetrack();

    @Query("SELECT e FROM TimeTrackEntity e WHERE NOT EXISTS (SELECT r FROM e.myTimetrack r WHERE r.id <> ?1)")
    public List<TimeTrackEntity> findAllWithoutOtherMyTimetrack(Long id);
}
