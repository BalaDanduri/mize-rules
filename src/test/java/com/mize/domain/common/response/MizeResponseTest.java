package com.mize.domain.common.response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mize.domain.brand.Brand;

public class MizeResponseTest extends MizeDomainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ResponseMeta meta = new ResponseMeta("Brand.Ok", null,10,900L,1,90L,340L,"1.2","GET /brands/");
		
		ResponseLink link0 = new ResponseLink("Brand Support", "/brand/support/{items.id}", new String[]{"BrandSupport"});
		ResponseLink link1 = new ResponseLink("Brand Details", "/brand/details/{items.id}", new String[]{"BrandDetails"});
		
		List<ResponseLink> rels = new ArrayList<ResponseLink>();
		rels.add(link0);
		rels.add(link1);
		
		Brand brand = new Brand(ONE, "APPLE", "http://apple.com");
		Brand brand1 = new Brand(TWO, "SAMSUNG", "http://samsung.com");
		
		List<Brand> brandList = new ArrayList<Brand>();
		brandList.add(brand);
		brandList.add(brand1);
		
		MizeResponse response = new MizeResponse(meta, rels, brandList);
		
		try {
			System.out.print( new ObjectMapper().writeValueAsString(response));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
