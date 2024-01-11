package com.qa.nationallottery.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.nationallottery.util.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By userName = By.xpath("//input[@id='userName_email' and @placeholder='Mobile / Email' and @name ='userName_email' ]");
	private By password  = By.xpath("(//input[@id='password' and @placeholder='Pin' and @name ='password' ])");
	private By loginBtn = By.xpath ("//div[@class='basicLoginWrap']//button[@type='submit'][normalize-space()='Login']");
	private By forgetPwdLink = By.xpath("//div[normalize-space()='Forgot Pin ?']"); 
	private By logoHomePage = By.xpath("//img[@class='sp-retina-logo hidden-xs']");
	private By popup = By.xpath("//span[@class='closeBTN' and text() = 'X']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	public String getLoginPageTitle() {
		
		String title =  eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println(title);
		return title;
	}
	
	public String getLoginPageURL() {
		
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println(url);
		return url;
	}

	public boolean getLogoHomePageDisplay() {
		return eleUtil.waitForVisibilityOfElement(logoHomePage, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
		 
	}

	public boolean getforgotLinkDisplay() {
		return eleUtil.waitForVisibilityOfElement(forgetPwdLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
		 
	}

	public AccountPage doLogin(String username, String pwd) throws InterruptedException {
		
		eleUtil.waitForVisibilityOfElement(popup, AppConstants.SHORT_DEFAULT_WAIT);
		eleUtil.doClick(popup);
		eleUtil.waitForVisibilityOfElement(userName,AppConstants.SHORT_DEFAULT_WAIT ).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		Thread.sleep(2000);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
		
	}
}
