package de.tt.service.impl;
import java.util.List;
import de.tt.persistence.entity.TimeTrackEntity;
import de.tt.persistence.repository.TimeTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * TimeTrack Service class
 *
 */
@Service
public class TimeTrackService implements ServiceInterface<TimeTrackEntity, TimeTrackRepository> {

    @Autowired
    private TimeTrackRepository timetrackRepository;

    @Override
    public TimeTrackRepository getRepository() {
        return timetrackRepository;
    }

    public List<TimeTrackEntity> findAllWithoutProject() {
        return timetrackRepository.findAllWithoutProject();
    }

    public List<TimeTrackEntity> findAllWithoutOtherProject(Long id) {
        return timetrackRepository.findAllWithoutOtherProject(id);
    }
    public List<TimeTrackEntity> findAllWithoutMyTimetrack() {
        return timetrackRepository.findAllWithoutMyTimetrack();
    }

    public List<TimeTrackEntity> findAllWithoutOtherMyTimetrack(Long id) {
        return timetrackRepository.findAllWithoutOtherMyTimetrack(id);
    }

}
