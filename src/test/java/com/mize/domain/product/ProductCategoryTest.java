package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductCategoryTest extends JPATest {
	
	
	EntityManager entityManager;
	EntityTransaction tx;
	ProductCategory prodCategory = null;
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		
		
	}

	private ProductCategory retrieveProdCatObject(){
		ProductCategory prodCat = null;
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("name", "Appliances");
	   List<ProductCategory> prodCats = getListFromDB("Select p from ProductCategory p where p.name =:name",parameters);
	   if(!Formatter.isEmpty(prodCats)){
		   prodCat = prodCats.get(0);
	   }
	   return prodCat;
	}
	
	
	@Test
	public void retrieveTest(){
		prodCategory = retrieveProdCatObject();
		try{
			if(prodCategory != null){
				assertTrue(prodCategory.getId() !=null);
			}
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
		
}
