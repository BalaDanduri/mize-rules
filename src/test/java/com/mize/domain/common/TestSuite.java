package com.mize.domain.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.mize.domain.test.util.JPATest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LocaleTest.class,
	CountryTest.class
})
public class TestSuite extends JPATest{
	
}
