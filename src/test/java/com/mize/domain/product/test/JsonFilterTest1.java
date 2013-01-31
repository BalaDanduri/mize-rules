package com.mize.domain.product.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mize.domain.product.Product;
import com.mize.domain.product.Products;
import com.mize.domain.util.PropertyFilter;

public class JsonFilterTest1 {

	Products obj = null;
	@Before
	public void setUp() throws Exception {
		obj = new Products();
		
		Product prodyuct1 = new Product();
		List<Product> products = new ArrayList<Product>();
		products.add(prodyuct1);
		
		obj.setProductList(products);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] ignoreFileds = {"category","upc","qrCode","productDetails"};
		String filterName = "PropertyFilter";
		
		ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
	    mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilter.class);
		
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName,SimpleBeanPropertyFilter.serializeAllExcept(ignoreFileds));
		ObjectWriter writer = new ObjectMapper().writer(filters);  
		try {
			assertNotNull(writer.writeValueAsString(obj));
			System.out.print(writer.writeValueAsString(obj));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
