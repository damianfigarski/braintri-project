package com.doddlecode.braintriproject.repository;

import com.doddlecode.braintriproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 OR e.lastName = ?1 OR e.email = ?1")
    List<Employee> findByFirstNameLastNameEmail(String param);
}
