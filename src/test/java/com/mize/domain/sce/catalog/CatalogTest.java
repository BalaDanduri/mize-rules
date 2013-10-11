/**
 * 
 */
package com.mize.domain.sce.catalog;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.h2.tools.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-context.xml"})
public class CatalogTest {

	
	@Autowired
	LocalContainerEntityManagerFactoryBean myEmf;
	
	@BeforeClass
	public static void launchH2Console() throws Exception {
		Console.main(new String[]{});		
	}
	
	@Before
	public void setUp() throws Exception {
		//template.update("delete from prod");
		
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("down");
	
	}
	

	@Test
	public void test()  {
		
		Catalog catalog = new Catalog(null,"123","ABC","Y",null);
		EntityManager mf = myEmf.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction tx = mf.getTransaction();
		tx.begin();
		mf.persist(catalog);
		tx.commit();
		System.out.println(catalog);
		mf.close();
		//Thread.sleep(1000000L);
	}

}
