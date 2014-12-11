package com.mize.domain.sce.part;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Country;
import com.mize.domain.common.Locale;
import com.mize.domain.part.Part;
import com.mize.domain.part.PartAttribute;
import com.mize.domain.part.PartIntl;
import com.mize.domain.part.PartPrice;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations = { "/test-context.xml" })
public class PartTest extends JPATest {

	private static String PART_QUERY = "select * from part where id = ?";
	private static String PART_INTL_QUERY = "select * from part_intl where part_id = ?";
	private static String PART_ATT_QUERY = "select * from part_attribute where part_id = ?";
	private static String PART_PRICES_QUERY = "select * from part_price where part_id = ?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	Part part = null;
	Part dbPart = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(part);
		tx.commit();
	}

	private void createMasterData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			tenant = createTenant();
			entityManager.persist(tenant);
			businessEntity = createBusinessEntity("dealer");
			businessEntity.setTenant(tenant);
			entityManager.persist(businessEntity);
			tx.commit();
		}
	}

	private void createPart() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			part = partObjectToSave();
			setPartIntls(part);
			setPartPrices(part);
			setPartAttributes(part);
			entityManager.persist(part);
			tx.commit();
		}

	}

	public  Part partObjectToSave() {
		Part part = new Part();
		part.setTenant(tenant);
		part.setCode("admin" + System.currentTimeMillis());
		part.setType("Test");
		part.setIsActive("Y");
		part.setIsKit("Y");
		part.setIsReturnable("Y");
		part.setIsSerialized("Y");
		part.setUom("Each");
		part.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		part.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).plusMonths(2));
		part.setCreatedBy(779l);
		part.setUpdatedBy(779l);
		return part;
	}

	private void setPartIntls(Part part) {
		List<PartIntl> partIntls = new ArrayList<PartIntl>();
		PartIntl partIntl = new PartIntl();
		Locale locale = findLocaleObjectFromDB();
		partIntl.setLocale(locale);
		partIntl.setPart(part);
		partIntl.setName("testAdmin");
		partIntl.setDescription("Testing");
		partIntls.add(partIntl);
		part.setPartIntl(partIntls);
	}

	private void setPartPrices(Part part) {
		List<PartPrice> partPrices = new ArrayList<PartPrice>();
		PartPrice partPrice = new PartPrice();
		Country country = findCountryObjectFromDB();
		partPrice.setCountry(country);
		partPrice.setPart(part);
		partPrice.setUnitPrice(BigDecimal.valueOf(1));
		partPrice.setListPrice(BigDecimal.valueOf(1));
		partPrice.setNetPrice(BigDecimal.valueOf(1));
		partPrice.setCurrencyCode("USD");
		partPrice.setTaxId(1l);
		partPrice.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		partPrice.setCreatedBy(776l);
		partPrice.setEndDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).plusMonths(2));
		partPrice.setStartDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		partPrice.setUpdatedBy(776l);
		partPrice.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).plusMonths(1));
		partPrices.add(partPrice);

		part.setPartPrices(partPrices);
	}

	private void setPartAttributes(Part part) {
		List<PartAttribute> partAttributes = new ArrayList<PartAttribute>();
		PartAttribute partAttribute = new PartAttribute();
		partAttribute.setPart(part);
		partAttribute.setCode("Height");
		partAttribute.setValue("attributeValue3");
		partAttribute.setUom("Standard");
		partAttributes.add(partAttribute);
		part.setPartAttributes(partAttributes);
	}

	public class PartRowMapper implements RowMapper<Part> {
		public Part mapRow(ResultSet resultSet, int arg1) throws SQLException {
			Part part = new Part();
			part.setId(resultSet.getLong("id"));
			part.setCode(resultSet.getString("part_code"));
			part.setIsActive(resultSet.getString("is_active"));
			part.setIsKit(resultSet.getString("is_kit"));
			part.setType(resultSet.getString("part_type"));
			part.setIsSerialized(resultSet.getString("is_serialized"));
			part.setIsReturnable(resultSet.getString("is_returnable"));
			part.setUom(resultSet.getString("uom"));
			part.setCreatedDate(Formatter.toMizeDateTime(resultSet
					.getTimestamp("created_date")));
			part.setUpdatedDate(Formatter.toMizeDateTime(resultSet
					.getTimestamp("updated_date")));
			BusinessEntity beEntity = new BusinessEntity();
			beEntity.setId(resultSet.getLong("tenant_id"));
			part.setTenant(beEntity);
			return part;
		}
	}

	public class PartIntlRowMapper implements RowMapper<PartIntl> {

		@Override
		public PartIntl mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartIntl partIntl = new PartIntl();
			partIntl.setId(rs.getLong("id"));

			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));

			partIntl.setLocale(locale);
			Part part = new Part();
			part.setId(rs.getLong("part_id"));
			partIntl.setPart(part);
			partIntl.setName(rs.getString("part_name"));
			partIntl.setDescription(rs.getString("part_description"));
			return partIntl;
		}

	}

	public class PartPriceRowMapper implements RowMapper<PartPrice> {

		@Override
		public PartPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartPrice partPrice = new PartPrice();
			partPrice.setId(rs.getLong("id"));
			Country country = new Country();
			country.setId(rs.getLong("country_id"));
			partPrice.setCountry(country);
			Part part = new Part();
			part.setId(rs.getLong("part_id"));
			partPrice.setPart(part);

			partPrice.setUnitPrice(rs.getBigDecimal("unit_price"));
			partPrice.setListPrice(rs.getBigDecimal("list_price"));
			partPrice.setNetPrice(rs.getBigDecimal("net_price"));
			partPrice.setCurrencyCode(rs.getString("currency_code"));
			partPrice.setTaxId(rs.getLong("tax_id"));
			partPrice.setCreatedDate(Formatter.toMizeDateTime(rs
					.getTimestamp("created_date")));
			partPrice.setCreatedBy(rs.getLong("created_by"));
			partPrice
					.setEndDate(Formatter.toMizeDate(rs.getTimestamp("end_date")));
			partPrice.setStartDate(Formatter.toMizeDate(rs
					.getTimestamp("start_date")));
			partPrice.setUpdatedBy(rs.getLong("updated_by"));
			partPrice.setUpdatedDate(Formatter.toMizeDateTime(rs
					.getTimestamp("updated_date")));

			return partPrice;
		}

	}

	public class PartAttributeRowMapper implements RowMapper<PartAttribute> {

		@Override
		public PartAttribute mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PartAttribute partAttribute = new PartAttribute();
			partAttribute.setId(rs.getLong("id"));
			Part part = new Part();
			part.setId(rs.getLong("part_id"));
			partAttribute.setPart(part);
			partAttribute.setCode(rs.getString("attribute_code"));
			partAttribute.setValue(rs.getString("attribute_value"));
			partAttribute.setUom(rs.getString("attribute_uom"));

			return partAttribute;
		}

	}

	private Part retrievPart() {
		dbPart = jdbcTemplate.queryForObject(PART_QUERY,
				new Object[] { part.getId() }, new PartRowMapper());
		if (dbPart != null) {
			List<PartIntl> intls = jdbcTemplate.query(PART_INTL_QUERY,
					new Object[] { dbPart.getId() }, new PartIntlRowMapper());
			dbPart.setPartIntl(intls);
		}
		if (dbPart != null) {
			List<PartPrice> prices = jdbcTemplate.query(PART_PRICES_QUERY,
					new Object[] { dbPart.getId() }, new PartPriceRowMapper());
			dbPart.setPartPrices(prices);
		}
		if (dbPart != null) {
			List<PartAttribute> partAttributes = jdbcTemplate.query(
					PART_ATT_QUERY, new Object[] { dbPart.getId() },
					new PartAttributeRowMapper());
			dbPart.setPartAttributes(partAttributes);
		}
		return dbPart;
	}

	@Test
	public void savePartObjectTest() {
		createPart();
		try {
			if (part != null) {
				dbPart = retrievPart();
				if(dbPart != null){
					assertTrue(part.getId() != null);
					assertTrue(compare(part, dbPart));
				}
			}
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	@Test
	public void updatePartObjectTest() {
		createPart();
		try {
			if (part != null) {
				part.setCode("testAdmin" + System.currentTimeMillis());
				part.setType("mizeInc");
				persist();
				dbPart = retrievPart();
				if(dbPart != null){
					assertTrue(part.getId() != null);
					assertTrue(compare(part, dbPart));
				}
			}
			tearDown();
			}catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	public void tearDown() throws Exception {
		try {
			if (part != null) {
				tx.begin();
				entityManager.remove(part);
				entityManager.remove(businessEntity);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	private boolean compare(Part part ,Part dbPart){
		if(part == null && dbPart == null){
			return true;
		}
		if(part == null  ){
			if(dbPart != null){
				return false;
			}
		}else if(part!=null ){
			if(dbPart == null){
				return false;
			}
		}
		if(!part.getId().equals(dbPart.getId())){
			return false;
		}
		if(!part.getCode().equals(dbPart.getCode())){
			return false;
		}
		return true;
	}

}
