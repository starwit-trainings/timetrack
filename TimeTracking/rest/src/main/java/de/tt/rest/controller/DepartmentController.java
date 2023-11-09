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

import de.tt.persistence.entity.DepartmentEntity;
import de.tt.service.impl.DepartmentService;
import de.tt.persistence.exception.NotificationException;
import de.tt.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Department RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/department")
public class DepartmentController {

    static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "Get all department")
    @GetMapping
    public List<DepartmentEntity> findAll() {
        return this.departmentService.findAll();
    }


    @Operation(summary = "Get department with id")
    @GetMapping(value = "/{id}")
    public DepartmentEntity findById(@PathVariable("id") Long id) {
        return this.departmentService.findById(id);
    }

    @Operation(summary = "Create department")
    @PostMapping
    public DepartmentEntity save(@Valid @RequestBody DepartmentEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update department")
    @PutMapping
    public DepartmentEntity update(@Valid @RequestBody DepartmentEntity entity) {
        return departmentService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete department")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        departmentService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Department not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.department.notfound", "Department not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
