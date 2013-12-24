package com.mize.domain.sce.serviceEntity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import com.mize.domain.common.Country;
import com.mize.domain.common.State;
import com.mize.domain.serviceentity.ServiceEntityAddress;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class SEAddressTest extends JPATest {
	private static final String SE_ADDRESS_QUERY = "select * from service_entity_address where id = ?";
	EntityManager entityManager = null;
	ServiceEntityAddress sEAddress = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		sEAddress = findExistingSEAddress(entityManager);
		this.sEAddress = getSEAddressObjectToSave(sEAddress);
		EntityTransaction tx =entityManager.getTransaction();
		tx.begin();
		entityManager.persist(sEAddress);
		tx.commit();
	}

	@Test
	public void test() {
		try {
			List<ServiceEntityAddress>  addresses = jdbcTemplate.query(SE_ADDRESS_QUERY, new Object[]{sEAddress.getId()}, new SEAddressRowMapper());
			if(!Formatter.isEmpty(addresses)){
				ServiceEntityAddress seaddress = addresses.get(0);
				assertTrue(sEAddress.getId().equals(seaddress.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class SEAddressRowMapper implements RowMapper<ServiceEntityAddress> {
		@Override
		public ServiceEntityAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServiceEntityAddress address = new ServiceEntityAddress();
			address.setId(rs.getLong("id"));
			address.setType(rs.getString("address_type"));
			address.setAddress1(rs.getString("address_1"));
			address.setAddress2(rs.getString("address_2"));
			address.setAddress3(rs.getString("address_3"));
			address.setZip(rs.getString("zip"));
			address.setZipExt(rs.getString("zip_ext"));
			address.setCity(rs.getString("city"));
			State state = new State();
			state.setId(rs.getLong("state_id"));
			address.setState(state);
			Country country = new Country();
			country.setId(rs.getLong("country_id"));
			address.setCountry(country);
			address.setPhone1(rs.getString("phone_1"));
			address.setPhone2(rs.getString("phone_2"));
			address.setEmail(rs.getString("email"));
			address.setFax(rs.getString("fax"));
			address.setCounty(rs.getString("county"));
			return address;
		}
	}
	
	private ServiceEntityAddress getSEAddressObjectToSave(ServiceEntityAddress sEAddress) {
		ServiceEntityAddress address = new ServiceEntityAddress("address_type","address1","address2","address3","50000","50000","alabama",null,null,"7878787878","8989898989","raghu@gmail.com","9898989898","US");
		return address;
	}
}
