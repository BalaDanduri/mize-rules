package com.mize.domain.test;

import org.junit.Test;

import com.mize.domain.product.Engagement;
import com.mize.domain.user.Group;

public class UserSignupTest extends ValidationUtil{

	@Test
	public void validateUserSingup(){
		Group group = new Group();
		group.setCode("bala");
		validate(group,true);
	}
	
	@Test
	public void validateUserEngagement(){
		Engagement engagement = new Engagement();
		engagement.setMaxRedemptions(11);
		validate(engagement,true);
	}

}
