package com.doddlecode.braintriproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Position {
    @Id
    @GeneratedValue
    private Long id;
    private String positionName;
    @OneToMany(mappedBy = "position")
    @JsonIgnoreProperties(value = "position", allowSetters = true)
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(String positionName, List<Employee> employeeList) {
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(id, position.id) &&
                Objects.equals(positionName, position.positionName) &&
                Objects.equals(employeeList, position.employeeList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, positionName, employeeList);
    }
}
