package de.tt.service.impl;
import java.util.List;
import de.tt.persistence.entity.EmployeeEntity;
import de.tt.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Employee Service class
 *
 */
@Service
public class EmployeeService implements ServiceInterface<EmployeeEntity, EmployeeRepository> {

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public List<EmployeeEntity> findAllWithoutEmployeeTimeTrack() {
        return employeeRepository.findAllWithoutEmployeeTimeTrack();
    }

    public List<EmployeeEntity> findAllWithoutOtherEmployeeTimeTrack(Long id) {
        return employeeRepository.findAllWithoutOtherEmployeeTimeTrack(id);
    }

}
