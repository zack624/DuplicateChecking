package home.nust.dc.dao;

import static org.junit.Assert.*;
import home.nust.dc.entity.Duplicatechecking;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DuplicateCheckingDaoTest {

	DuplicateCheckingDao dao;
	
	@Test
	public void testFindById() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.dao = (DuplicateCheckingDao) ctx.getBean("duplicateCheckingDao");
		
		Duplicatechecking me = dao.findById(new Long(912101400113L));
		System.out.println(me);
	}

}
