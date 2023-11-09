package de.tt.service.impl;
import de.tt.persistence.entity.DepartmentEntity;
import de.tt.persistence.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import de.tt.persistence.entity.EmployeeEntity;
import de.tt.persistence.repository.EmployeeRepository;

/**
 * 
 * Department Service class
 *
 */
@Service
public class DepartmentService implements ServiceInterface<DepartmentEntity, DepartmentRepository> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DepartmentRepository getRepository() {
        return departmentRepository;
    }


    @Override
    public DepartmentEntity saveOrUpdate(DepartmentEntity entity) {

        Set<EmployeeEntity> employeeToSave = entity.getEmployee();

        if (entity.getId() != null) {
            DepartmentEntity entityPrev = this.findById(entity.getId());
            for (EmployeeEntity item : entityPrev.getEmployee()) {
                EmployeeEntity existingItem = employeeRepository.getById(item.getId());
                existingItem.setDepartment(null);
                this.employeeRepository.save(existingItem);
            }
        }

        entity.setEmployee(null);
        entity = this.getRepository().save(entity);
        this.getRepository().flush();

        if (employeeToSave != null && !employeeToSave.isEmpty()) {
            for (EmployeeEntity item : employeeToSave) {
                EmployeeEntity newItem = employeeRepository.getById(item.getId());
                newItem.setDepartment(entity);
                employeeRepository.save(newItem);
            }
        }
        return this.getRepository().getById(entity.getId());
    }
}
