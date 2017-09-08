package imcs.trng.raghu.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imcs.trng.raghu.dao.model.Employee;
import imcs.trng.raghu.rest.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;

	@RequestMapping(value = "/{empNo}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable int empNo) throws SQLException {
		Employee emp = empService.getEmployee(empNo);
		if (null != emp)
			return new ResponseEntity<>(emp, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getEmployees(@RequestParam int deptNo)  throws SQLException{
		List<Employee> emps = empService.getEmployees(deptNo);
		if(emps.size()==0)
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(emps, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{empNo}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable int empNo)  throws SQLException{
		if(empService.deleteEmployee(empNo))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) throws SQLException{
		if(empService.updateEmployee(emp))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)  throws SQLException{
		System.out.println("Employee Add Rest"+emp.getDeptNo()+" "+emp.getEmpName());
		int id=empService.addEmployee(emp);
		System.out.println("id"+id);
		if(id!=0)
			return new ResponseEntity<>(id,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SQLException.class)
	public void handleUserNotFoundException(SQLException ex) {

	}
}