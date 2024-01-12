package com.qa.nationallottery.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.qa.nationallottery.base.BaseTest;
import com.qa.nationallottery.contants.AppConstants;


public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test (priority = 2)
	public void loginPageCuurentURL() {
		String URL = loginpage.getLoginPageURL();
		Assert.assertEquals(URL,AppConstants.LOGIN_PAGE_URL);
	}

	@Test(priority = 3)
	public void logoHomePageIsPresent() {

		Assert.assertTrue(loginpage.getLogoHomePageDisplay());
	}

	@Test (priority = 4)
	public void forgotLinkIsPresent() {
		Assert.assertTrue(loginpage.getforgotLinkDisplay());
	}

	@Test (priority = 5)
	public void loginTest() throws InterruptedException {
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accPage.logoutLinkIsVisiable());
		
	}

}
