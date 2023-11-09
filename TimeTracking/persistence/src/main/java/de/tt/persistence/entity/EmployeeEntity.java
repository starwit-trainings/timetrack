package de.tt.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
 * Employee Entity class
 */
@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name = "name")
    private String name;


    @Column(name = "givenname")
    private String givenname;


    @Column(name = "profession")
    private String profession;


    // entity relations
    @JsonFilter("filterId")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @JsonFilter("filterId")
    @OneToMany(mappedBy = "myTimetrack")
    private Set<TimeTrackEntity> employeeTimeTrack;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    // entity relations getters and setters
    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public Set<TimeTrackEntity> getEmployeeTimeTrack() {
        return employeeTimeTrack;
    }

    public void setEmployeeTimeTrack(Set<TimeTrackEntity> employeeTimeTrack) {
        this.employeeTimeTrack = employeeTimeTrack;
    }

}
