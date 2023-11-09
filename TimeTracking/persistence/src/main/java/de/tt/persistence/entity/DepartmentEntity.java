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
 * Department Entity class
 */
@Entity
@Table(name = "department")
public class DepartmentEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name = "name")
    private String name;


    // entity relations
    @JsonFilter("filterId")
    @OneToMany(mappedBy = "department")
    private Set<EmployeeEntity> employee;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // entity relations getters and setters
    public Set<EmployeeEntity> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<EmployeeEntity> employee) {
        this.employee = employee;
    }

}
