package com.qa.nationallottery.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.nationallottery.factory.DriverFactory;
import com.qa.nationallottery.pages.AccountPage;
import com.qa.nationallottery.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected AccountPage accPage;
	protected LoginPage loginpage;
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		 prop = df.initProp();
		driver = df.initDriver(prop);
		loginpage =  new  LoginPage(driver);
		accPage = new AccountPage(driver);
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
