package com.mize.domain.sce.serviceentity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.labor.LaborHour;
import com.mize.domain.part.Part;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductRegistration;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class ServiceEntityRequestTest extends JPATest {
	
	private static String SERVICE_ENTITY_REQUEST_QUERY = "select * from srvc_enty_rqst where id = ?";
	EntityManager entityManager;
	ServiceEntity serviceEntity;
	ServiceEntityRequest serviceEntityRequest;
	ServiceEntityRequestProduct requestProduct;
	ServiceEntityRequestCoverage coverage;
	ServiceEntityRequestPart requestPart;
	ServiceEntityRequestLabor labor;
	ServiceEntityRequestOther other;
	List<ServiceEntityRequestPart> parts;
	List<ServiceEntityRequestLabor> labors;
	List<ServiceEntityRequestOther> others;

	@Before
	public void setUp() {
		entityManager = getEntityManager();
	}
	
	@After
	public void tearDown() {
		if(serviceEntity != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(serviceEntityRequest);
			entityManager.remove(serviceEntity);
			tx.commit();
		}
		entityManager.close();
	}

	@Test
	public void saveServiceEntityRequest() {
		try {
			createServiceEntity();
			createServiceEntityRequest();
			createProduct();
			serviceEntityRequest.setProduct(requestProduct);
			createCoverage();
			serviceEntityRequest.setCoverage(coverage);
			createParts();
			serviceEntityRequest.setParts(parts);
			createLabors();
			serviceEntityRequest.setLabors(labors);
			createOthers();
			serviceEntityRequest.setOtherCharges(others);			
			persistServiceEntityRequest();
			ServiceEntityRequest dbServiceEntityRequest = jdbcTemplate.queryForObject(SERVICE_ENTITY_REQUEST_QUERY, new Object[]{serviceEntityRequest.getId()}, new ServiceEntityRequestRowMapper());
			assertTrue(dbServiceEntityRequest != null && dbServiceEntityRequest.getId() != null);
		} catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void retrieveServiceEntityRequest() {
		try {
			createServiceEntity();
			createServiceEntityRequest();
			createProduct();
			serviceEntityRequest.setProduct(requestProduct);
			createCoverage();
			serviceEntityRequest.setCoverage(coverage);
			createParts();
			serviceEntityRequest.setParts(parts);
			createLabors();
			serviceEntityRequest.setLabors(labors);
			createOthers();
			serviceEntityRequest.setOtherCharges(others);			
			persistServiceEntityRequest();
			
			TypedQuery<ServiceEntityRequest> query = entityManager.createQuery("select ser from ServiceEntityRequest ser where ser.id = "+serviceEntityRequest.getId(), ServiceEntityRequest.class);
			ServiceEntityRequest dbRequest = query.getSingleResult();
			assertTrue(dbRequest != null && dbRequest.getId() != null);
		}catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
		
	}
	
	
	private class ServiceEntityRequestRowMapper implements RowMapper<ServiceEntityRequest> {

		@Override
		public ServiceEntityRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServiceEntityRequest request = new ServiceEntityRequest();
			request.setId(rs.getLong("id"));
			request.setCauseCode(rs.getString("cause_code"));
			request.setCauseDescription(rs.getString("cause_descr"));
			request.setComplaintCode(rs.getString("complaint_code"));
			return request;
		}
		
	}
	
	private void prepareServiceEntity() {
		serviceEntity = new ServiceEntity();
		serviceEntity.setEntityCode("CLM123");
		serviceEntity.setEntityType("Claim");
		serviceEntity.setEntityStatus("DRAFT");
	}
	
	private void createServiceEntity() {
		prepareServiceEntity();
		persistServiceEntity();
	}
	
	private void persistServiceEntity() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(serviceEntity);
		tx.commit();
	}
	
	private void persistServiceEntityRequest() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(serviceEntityRequest);
		tx.commit();
	}
	
	private void createServiceEntityRequest() {
		serviceEntityRequest = new ServiceEntityRequest();
		serviceEntityRequest.setRequestType("Repair");
		serviceEntityRequest.setRepairSiteCode("RST100");
		serviceEntityRequest.setRepairDate(MizeDateTime.now().minusDays(3));
		serviceEntityRequest.setFailureDate(MizeDateTime.now().minusDays(4));
		
		serviceEntityRequest.setCauseCode("CUSC001");
		serviceEntityRequest.setCauseDescription("Monitor problem");
		serviceEntityRequest.setComplaintCode("COMP001");
		serviceEntityRequest.setComplaintDescription("Monitor is not working");
		serviceEntityRequest.setCorrectiveActionCode("CORC001");
		serviceEntityRequest.setCorrectiveActionDescription("Turn off and on the monitor");
		serviceEntityRequest.setCreatedBy(779L);
		serviceEntityRequest.setCreatedDate(MizeDateTime.now());
		serviceEntityRequest.setServiceEntity(serviceEntity);
		
		ServiceEntityAmount partAmount = new ServiceEntityAmount();
		partAmount.setRequestedQty(BigDecimal.valueOf(15));
		partAmount.setAdjustedQty(BigDecimal.valueOf(5));
		partAmount.setRequestedAmount(BigDecimal.valueOf(2560.75));
		partAmount.setAdjustedAmount(BigDecimal.valueOf(500.85));
		partAmount.setTaxAmount(BigDecimal.valueOf(215.25));
		partAmount.setTotalAmount(BigDecimal.valueOf(1565.35));
		
		serviceEntityRequest.setPartAmount(partAmount);
		
		ServiceEntityAmount laborAmount = new ServiceEntityAmount();
		laborAmount.setRequestedQty(BigDecimal.valueOf(15));
		laborAmount.setAdjustedQty(BigDecimal.valueOf(5));
		laborAmount.setRequestedAmount(BigDecimal.valueOf(2560));
		laborAmount.setAdjustedAmount(BigDecimal.valueOf(500));
		laborAmount.setTaxAmount(BigDecimal.valueOf(215));
		laborAmount.setTotalAmount(BigDecimal.valueOf(1565));
		
		serviceEntityRequest.setLaborAmount(laborAmount);
		
		ServiceEntityAmount otherAmount = new ServiceEntityAmount();
		otherAmount.setRequestedQty(BigDecimal.valueOf(0));
		otherAmount.setAdjustedQty(BigDecimal.valueOf(0));
		otherAmount.setRequestedAmount(BigDecimal.valueOf(175));
		otherAmount.setAdjustedAmount(BigDecimal.valueOf(25));
		otherAmount.setTaxAmount(BigDecimal.valueOf(25));
		otherAmount.setTotalAmount(BigDecimal.valueOf(200));
		
		serviceEntityRequest.setOtherAmount(otherAmount);
		
		ServiceEntityAmount totalAmount = new ServiceEntityAmount();
		totalAmount.setRequestedQty(BigDecimal.valueOf(0));
		totalAmount.setAdjustedQty(BigDecimal.valueOf(0));
		totalAmount.setRequestedAmount(BigDecimal.valueOf(1750));
		totalAmount.setAdjustedAmount(BigDecimal.valueOf(250));
		totalAmount.setTaxAmount(BigDecimal.valueOf(250));
		totalAmount.setTotalAmount(BigDecimal.valueOf(2000));
		
		serviceEntityRequest.setTotalAmount(totalAmount);
	}
	
	private void createProduct() {
		requestProduct = new ServiceEntityRequestProduct();
		requestProduct.setModel("SCS900");
		Product product = new Product();
		product.setId(3042637L);
		requestProduct.setProduct(product);
		requestProduct.setSerialNumber("SCS900100");
		ProductSerial serial = new ProductSerial();
		serial.setId(163L);
		requestProduct.setProductSerial(serial);
		requestProduct.setBrandName("Trimble");
		requestProduct.setCategoryName("Machines");			
		ProductRegistration registration = new ProductRegistration();
		registration.setId(355L);
		requestProduct.setRegistration(registration);
		requestProduct.setServiceEntityRequest(serviceEntityRequest);
	}
	
	private void createCoverage() {
		coverage = new ServiceEntityRequestCoverage();
		coverage.setServiceEntityRequest(serviceEntityRequest);
		coverage.setCoverageEndDate(MizeDateTime.now().addYears(1));
		coverage.setCoverageName("Standard 1 Year Warranty");
	}
	
	private void createParts() {
		requestPart = new ServiceEntityRequestPart();
		requestPart.setPartCode("MI0004");
		Part part = new Part();
		part.setId(41L);
		requestPart.setPart(part);
		requestPart.setPartName("Machine Bolt");
		requestPart.setPartDescription("Machine Bolt Description");
		requestPart.setPartSerial("MI-SRL-0122");
		requestPart.setPartType("Standard");
		requestPart.setPartUom("Quantity");
		
		ServiceEntityAmount partAmount = new ServiceEntityAmount();
		partAmount.setRequestedQty(BigDecimal.valueOf(15));
		partAmount.setAdjustedQty(BigDecimal.valueOf(5));
		partAmount.setRequestedAmount(BigDecimal.valueOf(2560.75));
		partAmount.setAdjustedAmount(BigDecimal.valueOf(500.85));
		partAmount.setTaxAmount(BigDecimal.valueOf(215.25));
		partAmount.setTotalAmount(BigDecimal.valueOf(1565.35));
		
		requestPart.setPartAmount(partAmount);
		
		parts = new ArrayList<ServiceEntityRequestPart>();
		parts.add(requestPart);
		requestPart.setServiceEntityRequest(serviceEntityRequest);
	}
	
	private void createLabors() {
		labor = new ServiceEntityRequestLabor();
		labor.setLaborCode("ABC200");
		labor.setLaborType("Inshop");
		labor.setLaborName("Machine Labor");
		labor.setLaborDescription("Machine Repair Labor");
		LaborHour laborHour = new LaborHour();
		laborHour.setId(66L);
		labor.setLaborHour(laborHour);
		
		ServiceEntityAmount laborAmount = new ServiceEntityAmount();
		laborAmount.setRequestedQty(BigDecimal.valueOf(15));
		laborAmount.setAdjustedQty(BigDecimal.valueOf(5));
		laborAmount.setRequestedAmount(BigDecimal.valueOf(2560));
		laborAmount.setAdjustedAmount(BigDecimal.valueOf(500));
		laborAmount.setTaxAmount(BigDecimal.valueOf(215));
		laborAmount.setTotalAmount(BigDecimal.valueOf(1565));
		
		labor.setLaborAmount(laborAmount);
		
		labor.setServiceEntityRequest(serviceEntityRequest);
		labors = new ArrayList<ServiceEntityRequestLabor>();
		labors.add(labor);
	}
	
	private void createOthers() {
		other = new ServiceEntityRequestOther();
		other.setChargeCode("CHRG001");
		other.setChargeType("Cleaning");
		other.setChargeDescription("Cleaning expenses");
		
		
		ServiceEntityAmount otherAmount = new ServiceEntityAmount();
		otherAmount.setRequestedQty(BigDecimal.valueOf(0));
		otherAmount.setAdjustedQty(BigDecimal.valueOf(0));
		otherAmount.setRequestedAmount(BigDecimal.valueOf(175));
		otherAmount.setAdjustedAmount(BigDecimal.valueOf(25));
		otherAmount.setTaxAmount(BigDecimal.valueOf(25));
		otherAmount.setTotalAmount(BigDecimal.valueOf(200));
		
		other.setChargeAmount(otherAmount);
		
		other.setServiceEntityRequest(serviceEntityRequest);
		others = new ArrayList<ServiceEntityRequestOther>();
		others.add(other);
	}

}
