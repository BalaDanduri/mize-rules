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

import com.mize.domain.part.Part;
import com.mize.domain.part.PartKit;
import com.mize.domain.part.PartKitItem;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations = { "/test-context.xml" })
public class PartKitTest extends JPATest {

	private static String PART_KIT_QUERY = "select * from part_kit where id=?";
	private static String PART_KIT_ITEMS_QUERY = "select * from part_kit_item where part_kit_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	PartTest partTest = new PartTest();
	Part part;
	PartKit partKit = null;
	PartKit dbPartKit = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();

	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(partKit);
		tx.commit();
	}

	private void createMasterData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			part = partTest.partObjectToSave();
			entityManager.persist(part);
			tx.commit();
		}
	}

	private void createPartKit() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			partKit = createPartKitObject(part);
			setPartKitItems(part, partKit);
			entityManager.persist(partKit);
			tx.commit();

		}
	}

	private PartKit createPartKitObject(Part part) {
		PartKit partKit = new PartKit();
		partKit.setPart(part);
		partKit.setPriceMethod("Kit");
		partKit.setType("Standard");
		partKit.setIsActive("Y");
		partKit.setCreatedBy(776L);
		partKit.setUpdatedBy(776L);
		partKit.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		partKit.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		partKit.setStartDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		partKit.setEndDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));

		return partKit;
	}

	private void setPartKitItems(Part part, PartKit partKit) {
		List<PartKitItem> partKitItems = new ArrayList<PartKitItem>();
		PartKitItem partKitItem = new PartKitItem();
		partKitItem.setPart(part);
		partKitItem.setPartKit(partKit);
		partKitItem.setPartQty(BigDecimal.valueOf(2));
		partKitItems.add(partKitItem);
		partKit.setPartKitItems(partKitItems);

	}

	public PartKit retrievPartKit() {
		dbPartKit = jdbcTemplate.queryForObject(PART_KIT_QUERY,
				new Object[] { partKit.getId() }, new PartKitRowMapper());
		if (dbPartKit != null) {
			List<PartKitItem> partKitItems = jdbcTemplate.query(
					PART_KIT_ITEMS_QUERY, new Object[] { dbPartKit.getId() },
					new PartKitItemsRowMapper());
			dbPartKit.setPartKitItems(partKitItems);
		}

		return dbPartKit;
	}

	public class PartKitRowMapper implements RowMapper<PartKit> {

		@Override
		public PartKit mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartKit partKit = new PartKit();
			Part part = new Part();
			part.setId(rs.getLong("id"));
			partKit.setPart(part);
			partKit.setId(rs.getLong("id"));
			partKit.setPriceMethod(rs.getString("price_method"));
			partKit.setType(rs.getString("kit_type"));
			partKit.setIsActive(rs.getString("is_active"));
			partKit.setCreatedBy(rs.getLong("created_by"));
			partKit.setUpdatedBy(rs.getLong("updated_by"));
			partKit.setCreatedDate(Formatter.toMizeDateTime(rs
					.getTimestamp("created_date")));
			partKit.setUpdatedDate(Formatter.toMizeDateTime(rs
					.getTimestamp("updated_date")));
			partKit.setStartDate(Formatter.toMizeDate(rs
					.getTimestamp("start_date")));
			partKit.setEndDate(Formatter.toMizeDate(rs.getTimestamp("end_date")));

			return partKit;
		}

	}

	public class PartKitItemsRowMapper implements RowMapper<PartKitItem> {

		@Override
		public PartKitItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartKitItem partKitItem = new PartKitItem();
			partKitItem.setId(rs.getLong("id"));
			Part part = new Part();
			part.setId(rs.getLong("id"));
			partKitItem.setPart(part);
			PartKit partKit = new PartKit();
			partKit.setId(rs.getLong("id"));
			partKitItem.setPartKit(partKit);
			partKitItem.setPartQty(rs.getBigDecimal("part_qty"));

			return partKitItem;
		}

	}

	public void tearDown() throws Exception {
		try {
			if (partKit != null) {
				tx.begin();
				entityManager.remove(partKit);
				entityManager.remove(part);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}

	@Test
	public void savePartKitTest() {

		createPartKit();
		try {
			if (partKit != null) {
				dbPartKit = retrievPartKit();
				if (dbPartKit != null) {
					assertTrue(compare(partKit, dbPartKit));
					assertTrue(partKit.getId() != null);
				}
			}
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	@Test
	public void updatePartKitTest() {
		createPartKit();
		try {
			if (partKit != null) {
				partKit.setPriceMethod("Item");
				partKit.setType("other");
				persist();
				dbPartKit = retrievPartKit();
				if (dbPartKit != null) {
					assertTrue(partKit.getId() != null);
					assertTrue(compare(partKit, dbPartKit));
				}
			}tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	private boolean compare(PartKit partKit, PartKit dbPartKit) {
		if (partKit == null && dbPartKit == null) {
			return true;
		}
		if (partKit == null) {
			if (dbPartKit != null) {
				return false;
			}
		} else if (partKit != null) {
			if (dbPartKit == null) {
				return false;
			}
		}
		if (!partKit.getId().equals(dbPartKit.getId())) {
			return false;
		}
		if (!partKit.getType().equals(dbPartKit.getType())) {
			return false;
		}
		return true;
	}
}
