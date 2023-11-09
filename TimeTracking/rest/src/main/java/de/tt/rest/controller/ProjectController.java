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
import de.tt.persistence.entity.ProjectEntity;
import de.tt.service.impl.ProjectService;
import de.tt.persistence.exception.NotificationException;
import de.tt.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Project RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/project")
public class ProjectController {

    static final Logger LOG = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Operation(summary = "Get all project")
    @GetMapping
    public List<ProjectEntity> findAll() {
        return this.projectService.findAll();
    }

    @Operation(summary = "Get project with id")
    @GetMapping(value = "/{id}")
    public ProjectEntity findById(@PathVariable("id") Long id) {
        return this.projectService.findById(id);
    }

    @Operation(summary = "Create project")
    @PostMapping
    public ProjectEntity save(@Valid @RequestBody ProjectEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update project")
    @PutMapping
    public ProjectEntity update(@Valid @RequestBody ProjectEntity entity) {
        return projectService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete project")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        projectService.delete(id);
    }

    @Operation(summary = "Get all employee without timetrack")
    @GetMapping(value = "/find-without-timetrack")
    public List<ProjectEntity> findAllWithoutTimetrack() {
        return projectService.findAllWithoutTimetrack();
    }

    @Operation(summary = "Get all employee without other timetrack")
    @GetMapping(value = "/find-without-other-timetrack/{id}")
    public List<ProjectEntity> findAllWithoutOtherTimetrack(@PathVariable("id") Long id) {
        return projectService.findAllWithoutOtherTimetrack(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Project not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.project.notfound", "Project not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
