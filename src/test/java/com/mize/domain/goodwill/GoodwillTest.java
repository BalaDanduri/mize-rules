package com.mize.domain.goodwill;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class GoodwillTest extends JPATest {
	private static final String GOOD_WILL_QUERY = "select * from goodwill where id = ?";
	EntityManager entityManager;
	Goodwill goodwill = null;
	EntityTransaction tx =null;
	
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		goodwill = goodwillObjectTobeSaved(goodwill);
		persist();
	}
	
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(goodwill);
		tx.commit();
	}
	
	
	@Test
	public void testSaveGoodwill() {
		try {
			List<Goodwill>  be = jdbcTemplate.query(GOOD_WILL_QUERY, new Object[]{goodwill.getId()}, new GoodwillRowMapper());
			if(!Formatter.isEmpty(be)){
				Goodwill goodWillList = be.get(0);
				assertTrue(goodwill.getId().equals(goodWillList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class GoodwillRowMapper implements RowMapper<Goodwill> {
		@Override
		public Goodwill mapRow(ResultSet rs, int rowNum) throws SQLException {
			Goodwill gw = new Goodwill();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			gw.setTenant(tenant);
			gw.setId(rs.getLong("id"));
			gw.setCode(rs.getString("goodwill_code"));
			gw.setStatusCode(rs.getString("goodwill_status"));
			gw.setTypeCode(rs.getString("goodwill_type"));
			gw.setCurrencyCode(rs.getString("currency_code"));
			gw.setReference(rs.getString("goodwill_reference"));
			gw.setAuthorisedBy(rs.getString("goodwill_auth_by"));
			/*gw.setStartDate(DateTime.now());
			gw.setEndDate(DateTime.now());*/
			BusinessEntity requestor = new BusinessEntity();
			requestor.setId(rs.getLong("rqstr_be_id"));
			gw.setRequestor(requestor);
			Product prod = new Product();
			prod.setId(rs.getLong("prod_id"));
			gw.setProduct(prod);
			ProductSerial prodSerial = new ProductSerial();
			prodSerial.setId(rs.getLong("prod_serial_id"));
			gw.setProductSerial(prodSerial);
			GoodwillAmount claimedAmount = new GoodwillAmount();
			claimedAmount.setId(rs.getLong("approved_amount_id"));
			gw.setClaimedAmount(claimedAmount);
			GoodwillAmount approvedAmt = new GoodwillAmount();
			approvedAmt.setId(rs.getLong("claimed_amount_id"));
			gw.setClaimedAmount(approvedAmt);
			gw.setClaimedEntityId(rs.getLong("claimed_entity_id"));
			gw.setClaimedEntityType(rs.getString("claimed_entity_type"));
			gw.setClaimedEntityCode(rs.getString("claimed_entity_code"));
			return gw;
		}
	}
	
	private Goodwill goodwillObjectTobeSaved(Goodwill goodwill) {
		Goodwill gw = new Goodwill();
		BusinessEntity tenant = new BusinessEntity();
		tenant.setId(7624L);
		//gw.setId(3L);
		gw.setTenant(tenant);
		gw.setCode("testCode");
		gw.setStatusCode("completed");
		gw.setTypeCode("dealer");
		gw.setCurrencyCode("USD");
		gw.setReference("REF00191");
		gw.setAuthorisedBy("REF01");
		gw.setStartDate(MizeDate.now());
		gw.setEndDate(MizeDate.now());
		BusinessEntity requestor = new BusinessEntity();
		requestor.setId(8822L);
		requestor.setCode("SAMREF001");
		requestor.setTypeCode("servicecenter");
		gw.setRequestor(requestor);
		Product prod = new Product();
		prod.setId(3042619L);
		gw.setProduct(prod);
		ProductSerial prodSerial = new ProductSerial();
		prodSerial.setId(844L);
		prodSerial.setSerialNumber("123321");
		prodSerial.setProduct(prod);
		gw.setProductSerial(prodSerial);
		GoodwillAmount claimedAmount = new GoodwillAmount();
		claimedAmount.setTotalAmount(new BigDecimal(100.00));
		gw.setClaimedAmount(claimedAmount);
		GoodwillAmount approvedAmt = new GoodwillAmount();
		claimedAmount.setTotalAmount(new BigDecimal(100.00));
		gw.setClaimedAmount(approvedAmt);
		gw.setClaimedEntityId(23L);
		gw.setClaimedEntityCode("claimCode");
		gw.setClaimedEntityType("claimType");
		
		List<GoodwillAudit> auditList = new ArrayList<GoodwillAudit>();
		GoodwillAudit audit = new GoodwillAudit();
		audit.setGoodwill(gw);
		audit.setStatus("completed");
		audit.setStatusBy(123L);
		audit.setStatusDate(MizeDateTime.now());
		auditList.add(audit);
		gw.setAudits(auditList);
		
		List<GoodwillComment> commentsList = new ArrayList<GoodwillComment>();
		GoodwillComment gwComment = new GoodwillComment();
		EntityComment entityComment = new EntityComment();
		//entityComment.setId(2384L);
		entityComment.setCommentType("internal");
		entityComment.setComments("masterComment");
		gwComment.setEntityComment(entityComment);
		gwComment.setGoodwill(gw);
		commentsList.add(gwComment);
		gw.setComments(commentsList);
		
		GoodwillAmount gwAmt = new GoodwillAmount();
		gwAmt.setLaborAmount(new BigDecimal(300.00));
		gwAmt.setPartAmount(new BigDecimal(300.00));
		gwAmt.setOtherAmount(new BigDecimal(300.00));
		gw.setApprovedAmount(gwAmt);
		return gw;
	}
	
	@After
	public void tearDown() throws Exception {
		try {
			if (goodwill != null) {
				tx.begin();
				entityManager.remove(goodwill);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
