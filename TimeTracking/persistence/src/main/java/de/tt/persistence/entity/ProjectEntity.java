package de.tt.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

import java.time.ZonedDateTime;
import de.tt.persistence.serializer.ZonedDateTimeSerializer;
import de.tt.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Project Entity class
 */
@Entity
@Table(name = "project")
public class ProjectEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name = "name")
    private String name;


    // entity relations
    @JsonFilter("filterId")
    @OneToMany(mappedBy = "project")
    private Set<TimeTrackEntity> timeTrack;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // entity relations getters and setters
    public Set<TimeTrackEntity> getTimeTrack() {
        return timeTrack;
    }

    public void setTimeTrack(Set<TimeTrackEntity> timeTrack) {
        this.timeTrack = timeTrack;
    }

}
