
package com.mize.domain.test.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.h2.tools.Console;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.businessentity.BusinessEntityIntl;
import com.mize.domain.catalog.Catalog;
import com.mize.domain.catalog.CatalogEntry;
import com.mize.domain.common.Country;
import com.mize.domain.common.Locale;
import com.mize.domain.common.State;
import com.mize.domain.form.FormDefinition;
import com.mize.domain.form.FormTemplateDefinition;
import com.mize.domain.serviceentity.ServiceEntity;
import com.mize.domain.serviceentity.ServiceEntityAddress;
import com.mize.domain.serviceentity.ServiceEntityAudit;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class JPATest {

	@Autowired
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public JPATest() {
		super();
	}	
		
	@BeforeClass
	public static void launchH2Console() throws Exception {
		// uncomment it if want to see H2console
		Console.main(new String[]{});
	}
	
	public <T> Object find(Class<T> name, Object pkey) {
		EntityManager mf = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		Object object = mf.find(name, pkey);
		mf.close();
		return object;
	}
	
	public Locale findLocaleObjectFromDB() {
		Locale locale = (Locale) find(Locale.class, new Long(1));
		return locale;
	}
	
	public State findStateObjectFromDB() {
		State state = (State) find(State.class, new Long(1));
		return state;
	}
	
	public BusinessEntityIntl findExistingBusinessEntityIntl(EntityManager entityManager) {
		BusinessEntityIntl intl =  (BusinessEntityIntl) find(BusinessEntityIntl.class, new Long(101));
		return intl;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findObjectFromDB(Class<?> cls,Long id) {
		return (T)find(cls, id);
	}
	
	public Country findCountryObjectFromDB() {
		Country country = (Country) find(Country.class, new Long(1));
		return country;
	}
	
	public BusinessEntity findExistingBEtoBeusedwiththecatalogastenantid() {
		BusinessEntity be = (BusinessEntity) find(BusinessEntity.class, new Long(961));
		return be;
	}
	
	public BusinessEntity findExistingBEtoBeusedwiththecatalogastenantid(EntityManager entityManager) {
		BusinessEntity be = (BusinessEntity) entityManager.find(BusinessEntity.class, new Long(961));
		return be;
	}
	
	public void persist(Object obj) {
		EntityManager mf = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction tx = mf.getTransaction();
		tx.begin();
		mf.persist(obj);
		tx.commit();
		mf.close();
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
	}
	
	public Catalog findExistingCatalog(EntityManager entityManager) {
		Catalog catalog = (Catalog) entityManager.find(Catalog.class, new Long(100));
		return catalog;
	}
	
	public CatalogEntry findExistingCatalogEntry(EntityManager entityManager) {
		CatalogEntry catalogEntry = (CatalogEntry) entityManager.find(CatalogEntry.class, new Long(102));
		return catalogEntry;
	}
	
	public BusinessEntity findExistingBE(EntityManager entityManager) {
		BusinessEntity be = (BusinessEntity) entityManager.find(BusinessEntity.class, new Long(961));
		return be;
	}
	
	public ServiceEntity findExistingServiceEntityObject(EntityManager entityManager) {
		ServiceEntity serviceEntity = (ServiceEntity) entityManager.find(ServiceEntity.class, new Long(201));
		return serviceEntity;
	}
	
	public ServiceEntityAddress findExistingSEAddress(EntityManager entityManager) {
		ServiceEntityAddress address = (ServiceEntityAddress) entityManager.find(ServiceEntityAddress.class, new Long(101));
		return address;
	}
	
	public ServiceEntityAudit findExistingSEAudit(EntityManager entityManager) {
		ServiceEntityAudit seAudit = (ServiceEntityAudit) entityManager.find(ServiceEntityAudit.class, new Long(801));
		return seAudit;
	}
	

	public <T> T findById(Long id,Class<T> cls,EntityManager entityManager) {
		return entityManager.find(cls,id);
	}
	
	public FormTemplateDefinition findExistingFormTemplateDef(EntityManager entityManager) {
		FormTemplateDefinition layoutdef = (FormTemplateDefinition) entityManager.find(FormTemplateDefinition.class, new Long(1));
		return layoutdef;
	}
	
	public FormDefinition findExistingFormDefinition(EntityManager entityManager) {
		FormDefinition formDef = (FormDefinition) entityManager.find(FormDefinition.class, new Long(1));
		return formDef;
	}

}