package de.tt.service.impl;
import de.tt.persistence.entity.TimeTrackEntity;
import de.tt.persistence.repository.TimeTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.tt.persistence.entity.ProjectEntity;
import de.tt.persistence.repository.ProjectRepository;
import de.tt.persistence.entity.EmployeeEntity;
import de.tt.persistence.repository.EmployeeRepository;

/**
 * 
 * TimeTrack Service class
 *
 */
@Service
public class TimeTrackService implements ServiceInterface<TimeTrackEntity, TimeTrackRepository> {

    @Autowired
    private TimeTrackRepository timetrackRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public TimeTrackRepository getRepository() {
        return timetrackRepository;
    }


    @Override
    public TimeTrackEntity saveOrUpdate(TimeTrackEntity entity) {

        Set<ProjectEntity> projectToSave = entity.getProject();
        Set<EmployeeEntity> myTimetrackToSave = entity.getMyTimetrack();

        if (entity.getId() != null) {
            TimeTrackEntity entityPrev = this.findById(entity.getId());
            for (ProjectEntity item : entityPrev.getProject()) {
                ProjectEntity existingItem = projectRepository.getById(item.getId());
                existingItem.setTimeTrack(null);
                this.projectRepository.save(existingItem);
            }
            for (EmployeeEntity item : entityPrev.getMyTimetrack()) {
                EmployeeEntity existingItem = employeeRepository.getById(item.getId());
                existingItem.setEmployeeTimeTrack(null);
                this.employeeRepository.save(existingItem);
            }
        }

        entity.setProject(null);
        entity.setMyTimetrack(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (projectToSave != null && !projectToSave.isEmpty()) {
            for (ProjectEntity item : projectToSave) {
                ProjectEntity newItem = projectRepository.getById(item.getId());
                newItem.setTimeTrack(entity);
                projectRepository.save(newItem);
            }
        }
        if (myTimetrackToSave != null && !myTimetrackToSave.isEmpty()) {
            for (EmployeeEntity item : myTimetrackToSave) {
                EmployeeEntity newItem = employeeRepository.getById(item.getId());
                newItem.setEmployeeTimeTrack(entity);
                employeeRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
