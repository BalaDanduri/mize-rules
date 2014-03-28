package com.mize.domain.test.util;




import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mize.domain.businessentity.BusinessEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class BusinessEntityJPATest {

	@Autowired
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public BusinessEntityJPATest() {
		super();
	}	
		
	@BeforeClass
	public static void launchH2Console() throws Exception {
		// uncomment it if want to see H2console
		//Console.main(new String[]{});
	}
	
	public <T> Object find(Class<T> name, Object pkey) {
		EntityManager mf = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		Object object = mf.find(name, pkey);
		mf.close();
		return object;
	}
	
	
	
	public void persist(Object obj) {
		EntityManager mf = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction tx = mf.getTransaction();
		tx.begin();
		mf.persist(obj);
		tx.commit();
		mf.close();
	}

	public EntityManager getEntityManager(String unitName) {
		entityManagerFactory.setPersistenceUnitName(unitName);
		return entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
	} 
	
	public BusinessEntity findExistingBE(EntityManager entityManager) {
		BusinessEntity be = (BusinessEntity) entityManager.find(BusinessEntity.class, new Long(961));
		return be;
	}
	
	

}