package imcs.trng.raghu.rest.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import imcs.trng.raghu.dao.model.Department;

@Service
public interface DepartmentService {
	public List<Department> getDepartments() throws SQLException;
	public Department getDepartment(int deptNo) throws SQLException;
}
