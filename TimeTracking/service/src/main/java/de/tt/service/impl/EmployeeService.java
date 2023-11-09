package de.tt.service.impl;

import java.util.List;
import de.tt.persistence.entity.EmployeeEntity;
import de.tt.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.tt.persistence.entity.TimeTrackEntity;
import de.tt.persistence.repository.TimeTrackRepository;

/**
 * 
 * Employee Service class
 *
 */
@Service
public class EmployeeService implements ServiceInterface<EmployeeEntity, EmployeeRepository> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TimeTrackRepository timetrackRepository;

    @Override
    public EmployeeRepository getRepository() {
        return employeeRepository;
    }

    public List<EmployeeEntity> findAllWithoutDepartment() {
        return employeeRepository.findAllWithoutDepartment();
    }

    public List<EmployeeEntity> findAllWithoutOtherDepartment(Long id) {
        return employeeRepository.findAllWithoutOtherDepartment(id);
    }

    public List<EmployeeEntity> findAllWithoutTimetrack() {
        return employeeRepository.findAllWithoutTimetrack();
    }

    public List<EmployeeEntity> findAllWithoutOtherTimetrack(Long id) {
        return employeeRepository.findAllWithoutOtherTimetrack(id);
    }

    @Override
    public EmployeeEntity saveOrUpdate(EmployeeEntity entity) {

        Set<TimeTrackEntity> employeeTimeTrackToSave = entity.getEmployeeTimeTrack();

        if (entity.getId() != null) {
            EmployeeEntity entityPrev = this.findById(entity.getId());
            for (TimeTrackEntity item : entityPrev.getEmployeeTimeTrack()) {
                TimeTrackEntity existingItem = timetrackRepository.getById(item.getId());
                existingItem.setMyTimetrack(null);
                this.timetrackRepository.save(existingItem);
            }
        }

        entity.setEmployeeTimeTrack(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (employeeTimeTrackToSave != null && !employeeTimeTrackToSave.isEmpty()) {
            for (TimeTrackEntity item : employeeTimeTrackToSave) {
                TimeTrackEntity newItem = timetrackRepository.getById(item.getId());
                newItem.setMyTimetrack(entity);
                timetrackRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
