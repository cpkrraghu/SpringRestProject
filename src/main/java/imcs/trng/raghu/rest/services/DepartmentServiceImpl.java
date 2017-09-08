package imcs.trng.raghu.rest.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imcs.trng.raghu.dao.DepartmentDAO;
import imcs.trng.raghu.dao.model.Department;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDAO deptDao;
	
	@Override
	public List<Department> getDepartments() throws SQLException {
		// TODO Auto-generated method stub
		return deptDao.getDepartments();
	}

	@Override
	public Department getDepartment(int deptNo) throws SQLException {
		// TODO Auto-generated method stub
		return deptDao.getDepartment(deptNo);
	}
	
}
