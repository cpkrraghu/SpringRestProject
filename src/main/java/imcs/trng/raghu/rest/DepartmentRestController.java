package imcs.trng.raghu.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import imcs.trng.raghu.dao.model.Department;
import imcs.trng.raghu.rest.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentRestController {
	
	@Autowired
	DepartmentService deptService;
	
	@RequestMapping(value="/{deptNo}", method=RequestMethod.GET)
	public ResponseEntity<?> getDepartment(@PathVariable int deptNo) throws SQLException {
		Department dept = deptService.getDepartment(deptNo);
		if(null!=dept)
			return new ResponseEntity<>(dept, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployees() throws SQLException {
		List<Department> depts = deptService.getDepartments();
		 
		if(depts.size()>0)
			return new ResponseEntity<>(depts, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		
	}
}