package com.mize.domain.form.link;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.form.FormDefinition;
import com.mize.domain.product.Product;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormDefinitionLinkTest extends JPATest {
	
	private static final String FORM_DEF_LINK_QUERY = "select * from form_defn_link where id = ? ";
	
	EntityManager entityManager = null;
	FormDefinitionLink formDefinitionLink = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		entityManager = getEntityManager();
		formDefinitionLink = getFormDefinitionLink();		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(formDefinitionLink.getId() == null){
			entityManager.persist(formDefinitionLink);	
		}else{
			formDefinitionLink = entityManager.merge(formDefinitionLink);
		}		
		tx.commit();
	}	
	
	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

		
	@Test
	public void testFormDefinitionLink() {
		try {				
           FormDefinitionLink formDefinitionLinkDB =  jdbcTemplate.queryForObject(FORM_DEF_LINK_QUERY, new FormDefinitionLinkRowMapper(), new Object[]{formDefinitionLink.getId()});
           assertTrue(formDefinitionLink.getId().equals(formDefinitionLinkDB.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
			throw e;
		}		
		
	}
	
	class FormDefinitionLinkRowMapper implements RowMapper<FormDefinitionLink> {

		@Override
		public FormDefinitionLink mapRow(ResultSet rs, int arg1) throws SQLException {
			FormDefinitionLink formDefinitionLink = new FormDefinitionLink();
			formDefinitionLink.setId(rs.getLong("id"));
			return formDefinitionLink;
		}
		
	}
	
	private FormDefinitionLink getFormDefinitionLink() {
		FormDefinitionLink formDefinitionLink = new FormDefinitionLink();
		formDefinitionLink.setId(1L);
		FormDefinition formDefinition = entityManager.find(FormDefinition.class, 1L);
		formDefinitionLink.setFormDefinition(formDefinition);
		
		FormDefinitionLinkData formDefinitionLinkData = new FormDefinitionLinkData();
		Product product = entityManager.find(Product.class, 101000L);
		formDefinitionLinkData.setProduct(product);
		formDefinitionLinkData.setLinkType("Pre-Delivery");
		formDefinitionLinkData.setLinkDuration("1");
		formDefinitionLinkData.setFormDefinitionLink(formDefinitionLink);
		List<FormDefinitionLinkData> data = new ArrayList<FormDefinitionLinkData>();
		data.add(formDefinitionLinkData);
		formDefinitionLink.setFormDefnLinkData(data);
		
		return formDefinitionLink;
	}
	

}
