package imcs.trng.raghu.rest.app;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import imcs.trng.raghu.dao.EmployeeDAO;
import imcs.trng.raghu.dao.EmployeeDAOImpl;
import imcs.trng.raghu.dao.model.Employee;
import imcs.trng.raghu.rest.config.RestConfig;

public class App {

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) throws SQLException {
		initAppContext();
		beanUsage();
	}

	static void initAppContext() {
		applicationContext = new AnnotationConfigApplicationContext(RestConfig.class);
	}
	
	static void beanUsage() throws SQLException {
		RestTemplate rt=new RestTemplate();
	}
	
}
