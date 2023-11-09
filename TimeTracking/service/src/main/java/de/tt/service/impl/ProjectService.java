package de.tt.service.impl;
import de.tt.persistence.entity.ProjectEntity;
import de.tt.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.tt.persistence.entity.TimeTrackEntity;
import de.tt.persistence.repository.TimeTrackRepository;

/**
 * 
 * Project Service class
 *
 */
@Service
public class ProjectService implements ServiceInterface<ProjectEntity, ProjectRepository> {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TimeTrackRepository timetrackRepository;

    @Override
    public ProjectRepository getRepository() {
        return projectRepository;
    }


    @Override
    public ProjectEntity saveOrUpdate(ProjectEntity entity) {

        Set<TimeTrackEntity> timeTrackToSave = entity.getTimeTrack();

        if (entity.getId() != null) {
            ProjectEntity entityPrev = this.findById(entity.getId());
            for (TimeTrackEntity item : entityPrev.getTimeTrack()) {
                TimeTrackEntity existingItem = timetrackRepository.getById(item.getId());
                existingItem.setProject(null);
                this.timetrackRepository.save(existingItem);
            }
        }

        entity.setTimeTrack(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (timeTrackToSave != null && !timeTrackToSave.isEmpty()) {
            for (TimeTrackEntity item : timeTrackToSave) {
                TimeTrackEntity newItem = timetrackRepository.getById(item.getId());
                newItem.setProject(entity);
                timetrackRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
