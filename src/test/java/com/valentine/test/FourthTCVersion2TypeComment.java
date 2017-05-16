package com.valentine.test;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;

public class FourthTCVersion2TypeComment {
	private HomePage onHomePage;
	
	@Test
	public void testClickMoreInfoAndOpensItemsPage(){
		onHomePage = AwfulValentine.openHomePage();
		onHomePage.clickMoreInfoOnSpecialOffer(5);
	}
		
	@Test(dependsOnMethods = "testClickMoreInfoAndOpensItemsPage")
	public void testFillFields(){
		
//		.fillNameField("");

		
	}
	@AfterClass
	public void tearDown(){
		AwfulValentine.close();
	}
	
	}
	


