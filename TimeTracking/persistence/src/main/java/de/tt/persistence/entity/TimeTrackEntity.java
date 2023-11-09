package de.tt.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

import java.time.ZonedDateTime;
import de.tt.persistence.serializer.ZonedDateTimeSerializer;
import de.tt.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * TimeTrack Entity class
 */
@Entity
@Table(name = "timetrack")
public class TimeTrackEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name="startdate")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime startDate;


    @Column(name="enddate")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime endDate;


    // entity relations
    @JsonFilter("filterId")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @JsonFilter("filterId")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity myTimetrack;

    // entity fields getters and setters
    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    // entity relations getters and setters
    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public EmployeeEntity getMyTimetrack() {
        return myTimetrack;
    }

    public void setMyTimetrack(EmployeeEntity myTimetrack) {
        this.myTimetrack = myTimetrack;
    }

}
