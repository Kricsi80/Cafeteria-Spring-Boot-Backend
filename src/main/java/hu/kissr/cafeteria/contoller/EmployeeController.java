package hu.kissr.cafeteria.contoller;

import hu.kissr.cafeteria.helperClass.EmployeeDebt;
import hu.kissr.cafeteria.model.Employee;
import hu.kissr.cafeteria.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> findAll() throws URISyntaxException {
        List<Employee> result = employeeService.findAll();
        return new ResponseEntity<List<Employee>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/debt/{month}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDebt>> getEmployeeDebt(@PathVariable Integer month) throws URISyntaxException {
        List<EmployeeDebt> result = employeeService.getEmployeeDebt(month);
        return new ResponseEntity<List<EmployeeDebt>>(result, HttpStatus.OK);
    }
}
