package imcs.trng.raghu.rest.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imcs.trng.raghu.dao.EmployeeDAO;
import imcs.trng.raghu.dao.EmployeeDAOImpl;
import imcs.trng.raghu.dao.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO empDao;
	
	public List<Employee> getEmployees(int deptNo) throws SQLException{
			return empDao.getEmployees(deptNo);
	}

	@Override
	public Employee getEmployee(int empId) throws SQLException{
		return empDao.getEmployee(empId);
	}

	@Override
	public boolean deleteEmployee(int empId) throws SQLException{
		return empDao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(Employee emp) throws SQLException{
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp);
	}

	@Override
	public int addEmployee(Employee emp) throws SQLException{
		// TODO Auto-generated method stub
		return empDao.addEmployee(emp);
	}
	
}
