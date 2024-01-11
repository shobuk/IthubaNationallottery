package com.qa.nationallottery.tests;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.nationallottery.base.BaseTest;
import com.qa.nationallottery.contants.AppConstants;



public class AccountPageTest extends BaseTest {

	@BeforeTest
	public void dologinTest() throws InterruptedException  {
		
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
//	@Test(priority =1)
//	public void loginpagetitleTest() {
//		
//		Assert.assertEquals(loginpage.getLoginPageTitle(),AppConstants.LOGIN_PAGE_TITLE);
//	}
	@Test
	public void getAccountPageTitleTest() {
	Assert.assertEquals(accPage.getAccountPageTitle(),AppConstants.ACCOUNT_PAGE_TITLE);
	}
	@Test
	public void getAccountPageURLTest() {
		Assert.assertTrue(accPage.getAccountPageURL().contains(AppConstants.ACCOUNT_PAGE_URL));
	}
	@Test
	public void myWalletIsVisiableTest() {
		Assert.assertTrue(accPage.myWalletIsVisiable());
	}
	@Test
	public void logoutLinkIsVisiableTest() {
		Assert.assertTrue(accPage.logoutLinkIsVisiable());
	}
}
