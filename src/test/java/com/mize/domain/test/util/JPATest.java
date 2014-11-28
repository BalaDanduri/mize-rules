
package com.mize.domain.test.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.businessentity.BusinessEntityAddress;
import com.mize.domain.businessentity.BusinessEntityBrand;
import com.mize.domain.businessentity.BusinessEntityContact;
import com.mize.domain.businessentity.BusinessEntityIntl;
import com.mize.domain.catalog.Catalog;
import com.mize.domain.catalog.CatalogEntry;
import com.mize.domain.common.Country;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Gender;
import com.mize.domain.common.Locale;
import com.mize.domain.common.State;
import com.mize.domain.form.FormDefinition;
import com.mize.domain.form.FormTemplateDefinition;
import com.mize.domain.product.Product;
import com.mize.domain.serviceentity.ServiceEntity;
import com.mize.domain.serviceentity.ServiceEntityAddress;
import com.mize.domain.serviceentity.ServiceEntityAudit;
import com.mize.domain.user.UserProfile;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.MizeDateTime;
import com.mize.domain.util.MizeObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class JPATest {

	@Autowired
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private static String brandQuery = "select * from brand where brand_name=?";
	private static MizeObjectMapper mapper = MizeObjectMapper.getInstance();

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public JPATest() {
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
		BusinessEntity be = (BusinessEntity) entityManager.find(BusinessEntity.class, new Long(7624l));
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
	
	public static String getJsonResponse(Object object) throws Exception {
		return mapper.writeValueAsString(object);
	}
	
	@SuppressWarnings("unchecked")
	public static  <T> T  getObjectFromRequest(String request,Class<?> valueType) throws Exception{			
		Object readValue = mapper.readValue(request, valueType);
		return (T) readValue;
	}
	
	public BusinessEntity createTenant(){
		return createBusinessEntity("company");
	}
	public Brand findBrandObjectFromDB() {
		Brand brand = null;
		Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("name", "Trimble");
		   List<Brand> brands = getListFromDB("Select b from Brand b where b.name =:name",parameters);
		   if(!Formatter.isEmpty(brands)){
			   brand = brands.get(0);
		   }
		return brand;
	}
	@SuppressWarnings("unchecked")
	public<T> List<T> getListFromDB(String sqlQuery, Map<String,Object> parameters){
		Query query = getEntityManager().createQuery(sqlQuery); 
		if(!Formatter.isEmpty(parameters)){
			for(String key : parameters.keySet()){
				query.setParameter(key, parameters.get(key));
			}
		}
		return query.getResultList();
	}

	public Product findExistingProduct(EntityManager entityManager) {
		return entityManager.find(Product.class, new Long(101000));
	}

	public BusinessEntity createBusinessEntity(String type) {
		if (type != null) {
			BusinessEntity tenant = new BusinessEntity();
			tenant.setTypeCode(type.toLowerCase());
			tenant.setCode(type.toUpperCase() + System.currentTimeMillis());
			tenant.setName("Test M-ize" + type);
			tenant.setCurrencyCode("USD");
			tenant.setIsActive("Y");
			tenant.setCreatedBy(1l);
			tenant.setUpdatedBy(1l);
			tenant.setCreatedDate(MizeDateTime.now());
			tenant.setUpdatedDate(MizeDateTime.now());
			if (!type.equalsIgnoreCase("company")) {
				BusinessEntityIntl intl = new BusinessEntityIntl();
				intl.setName(type);
				intl.setFirstName("F_N" +type);
				intl.setLastName("L_N"+ type);
				intl.setBusinessEntity(tenant);
				tenant.getIntl().add(intl);
				intl.setLocale(findLocaleObjectFromDB());
			}
			return tenant;
		}

		return null;
	}
	
	public User createUser(){
		User user = new User();
		user.setEmail("admin"+System.currentTimeMillis()+"@mize.com");
		user.setName("Mize");
		user.setLastLogin(MizeDateTime.now());
		user.setCreatedDate(MizeDateTime.now());
		user.setUpdatedDate(MizeDateTime.now());
		UserProfile userProfile = user.getUserProfile();
		if(userProfile == null){
			userProfile = new UserProfile();
		}
		userProfile.setEmailOptOut("N");
		userProfile.setFirstName("Test");
		userProfile.setLastName("Admin");
		userProfile.setBirthdate(MizeDateTime.now().minusYears(28));
		userProfile.setGender(Gender.F);
		userProfile.setUser(user);
		
		return user;
	}
	
	public EntityComment createEntityComment()
	{
		EntityComment comment = new EntityComment();
		comment.setCommentType("internal");
		comment.setComments("masterComment");
		return comment;
	}

	public Product productObjectToSave(BusinessEntity tenant,BusinessEntity businessEntity ,EntityManager entityManager) {
		Product product = new Product();
		product.setName("Testp");	
		Brand brand = findById(1l, Brand.class, entityManager);
		product.setBrand(brand);
		product.setTenant(tenant);
		product.setManufacturerBE((businessEntity));
		product.setCreatedDate(MizeDateTime.now());
		product.setUpdatedDate(MizeDateTime.now());
		product.setReleaseDate(MizeDate.now());
		
		return product;

	}
	public EntityAddress createEntityAddress()
	{
		EntityAddress entityAddress = new EntityAddress();
		entityAddress.setAddress1("tampa");
		entityAddress.setAddress2("us");
		entityAddress.setCity("hyderabad");
		entityAddress.setCountry(findCountryObjectFromDB());
		entityAddress.setEmail("mizeAdmin"+System.currentTimeMillis()+"@mize.com");
		return entityAddress;
		
	}
	
	
	public void createBusinessEntityContact(BusinessEntity tenant) {
        BusinessEntityContact beContact = new BusinessEntityContact();
        beContact.setBusinessEntity(tenant);
        tenant.getBeContact().add(beContact);
 }

	public void createBusinessEntityAddress(BusinessEntity tenant) {
        BusinessEntityAddress beAddress = new BusinessEntityAddress();
        //beAddress.setCreatedBy(2L);
        beAddress.setBusinessEntity(tenant);
        EntityAddress entityAddress = new EntityAddress();
        entityAddress.setAddress1("tampa");
        entityAddress.setAddress2("us");
        entityAddress.setCity("hyderabad");
        entityAddress.setCountry(findCountryObjectFromDB());
        entityAddress.setEmail("siri@gmail.com");
        
        beAddress.setEntityAddress(entityAddress);
        beAddress.setIsPreferred("y");
        tenant.getAddresses().add(beAddress);
 }

	public void createBusinessEntityIntl(String type, BusinessEntity tenant) {
        BusinessEntityIntl intl = new BusinessEntityIntl();
        intl.setName(type);
        intl.setFirstName("F_N" +type);
        intl.setLastName("L_N"+ type);
        intl.setBusinessEntity(tenant);
        tenant.getIntl().add(intl);
        intl.setLocale(findLocaleObjectFromDB());
 }

	public void createBusinessEntityBrand(BusinessEntity tenant) {
        BusinessEntityBrand beBrand = new BusinessEntityBrand();
        beBrand.setBrand(findBrandObjectFromDB());
        beBrand.setIsActive("y");
        //beBrand.setCreatedDate(DateTime.now());
        beBrand.setBusinessEntity(tenant);
        tenant.getBeBrand().add(beBrand);
 }



}