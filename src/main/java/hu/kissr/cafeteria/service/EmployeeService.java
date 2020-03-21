package hu.kissr.cafeteria.service;

import hu.kissr.cafeteria.helperClass.EmployeeDebt;
import hu.kissr.cafeteria.model.Employee;
import hu.kissr.cafeteria.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDebt> getEmployeeDebt(Integer month) {
        return employeeRepository.getDebtOfAllEmployeesByMonth(month);
    }
}
