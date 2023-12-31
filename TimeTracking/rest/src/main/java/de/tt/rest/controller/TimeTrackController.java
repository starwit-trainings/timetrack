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

import de.tt.persistence.entity.TimeTrackEntity;
import de.tt.service.impl.TimeTrackService;
import de.tt.persistence.exception.NotificationException;
import de.tt.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * TimeTrack RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/timetrack")
public class TimeTrackController {

    static final Logger LOG = LoggerFactory.getLogger(TimeTrackController.class);

    @Autowired
    private TimeTrackService timetrackService;

    @Operation(summary = "Get all timetrack")
    @GetMapping
    public List<TimeTrackEntity> findAll() {
        return this.timetrackService.findAll();
    }

    @Operation(summary = "Get all timetrack without project")
    @GetMapping(value = "/find-without-project")
    public List<TimeTrackEntity> findAllWithoutProject() {
        return timetrackService.findAllWithoutProject();
    }

    @Operation(summary = "Get all timetrack without other project")
    @GetMapping(value = "/find-without-other-project/{id}")
    public List<TimeTrackEntity> findAllWithoutOtherProject(@PathVariable("id") Long id) {
        return timetrackService.findAllWithoutOtherProject(id);
    }
    @Operation(summary = "Get all timetrack without myTimetrack")
    @GetMapping(value = "/find-without-myTimetrack")
    public List<TimeTrackEntity> findAllWithoutMyTimetrack() {
        return timetrackService.findAllWithoutMyTimetrack();
    }

    @Operation(summary = "Get all timetrack without other myTimetrack")
    @GetMapping(value = "/find-without-other-myTimetrack/{id}")
    public List<TimeTrackEntity> findAllWithoutOtherMyTimetrack(@PathVariable("id") Long id) {
        return timetrackService.findAllWithoutOtherMyTimetrack(id);
    }

    @Operation(summary = "Get timetrack with id")
    @GetMapping(value = "/{id}")
    public TimeTrackEntity findById(@PathVariable("id") Long id) {
        return this.timetrackService.findById(id);
    }

    @Operation(summary = "Create timetrack")
    @PostMapping
    public TimeTrackEntity save(@Valid @RequestBody TimeTrackEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update timetrack")
    @PutMapping
    public TimeTrackEntity update(@Valid @RequestBody TimeTrackEntity entity) {
        return timetrackService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete timetrack")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        timetrackService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("TimeTrack not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.timetrack.notfound", "TimeTrack not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
