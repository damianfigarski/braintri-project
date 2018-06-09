package com.doddlecode.braintriproject.repository;

import com.doddlecode.braintriproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE UPPER(e.firstName) LIKE %?1% OR UPPER(e.lastName) LIKE %?1% OR UPPER(e.email) LIKE %?1%")
    List<Employee> findByFirstNameLastNameEmail(String param);
}
