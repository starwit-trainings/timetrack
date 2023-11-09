package de.tt.rest.controller;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tt.persistence.entity.EmployeeEntity;
import de.tt.service.impl.EmployeeService;
import de.tt.persistence.exception.NotificationException;
import de.tt.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Employee RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/employee")
public class EmployeeController {

    static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employee")
    @GetMapping
    public List<EmployeeEntity> findAll() {
        return this.employeeService.findAll();
    }

    @Operation(summary = "Get all employee without department")
    @GetMapping(value = "/find-without-department")
    public List<EmployeeEntity> findAllWithoutDepartment() {
        return employeeService.findAllWithoutDepartment();
    }

    @Operation(summary = "Get all employee without other department")
    @GetMapping(value = "/find-without-other-department/{id}")
    public List<EmployeeEntity> findAllWithoutOtherDepartment(@PathVariable("id") Long id) {
        return employeeService.findAllWithoutOtherDepartment(id);
    }
    @Operation(summary = "Get all employee without employeeTimeTrack")
    @GetMapping(value = "/find-without-employeeTimeTrack")
    public List<EmployeeEntity> findAllWithoutEmployeeTimeTrack() {
        return employeeService.findAllWithoutEmployeeTimeTrack();
    }

    @Operation(summary = "Get all employee without other employeeTimeTrack")
    @GetMapping(value = "/find-without-other-employeeTimeTrack/{id}")
    public List<EmployeeEntity> findAllWithoutOtherEmployeeTimeTrack(@PathVariable("id") Long id) {
        return employeeService.findAllWithoutOtherEmployeeTimeTrack(id);
    }

    @Operation(summary = "Get employee with id")
    @GetMapping(value = "/{id}")
    public EmployeeEntity findById(@PathVariable("id") Long id) {
        return this.employeeService.findById(id);
    }

    @Operation(summary = "Create employee")
    @PostMapping
    public EmployeeEntity save(@Valid @RequestBody EmployeeEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update employee")
    @PutMapping
    public EmployeeEntity update(@Valid @RequestBody EmployeeEntity entity) {
        return employeeService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        employeeService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Employee not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.employee.notfound", "Employee not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
