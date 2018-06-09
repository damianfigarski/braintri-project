package com.doddlecode.braintriproject.controller;

import com.doddlecode.braintriproject.model.Employee;
import com.doddlecode.braintriproject.model.Position;
import com.doddlecode.braintriproject.repository.EmployeeRepository;
import com.doddlecode.braintriproject.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    public EmployeeController(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        if (employee != null) {
            Position position = positionRepository.findById(
                    employee.getPosition().getId()
            ).get();
            employee.setPosition(position);
            return employeeRepository.save(employee);
        }

        return null;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }

    @GetMapping("/filtered-employees")
    public List<Employee> getFilteredEmployees(@RequestParam("search") String search) {
        return employeeRepository.findByFirstNameLastNameEmail(search);
    }

    @PostMapping("create-position")
    public Position createPosition(@RequestBody Position position) {
        if (positionRepository.findByPositionName(position.getPositionName()) != null) {
            return null;
        }
        if (position != null) {
            return positionRepository.save(position);
        }

        return null;
    }

    @GetMapping("/positions")
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }
}
