package com.qa.nationallottery.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.nationallottery.contants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	private By logoutLink = By.xpath("//a[text() = 'LOGOUT']");
	private By myWalletLink = By
			.xpath("//a[contains(@title,'My Wallet')]//span[@class='image-title'][normalize-space()='My Wallet']");
	// span[text() = 'My Wallet']//preceding-sibling::img[@alt = 'My Wallet']

	public String getAccountPageTitle() {
		String accPageTitle = eleUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE,AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println(accPageTitle);
		return accPageTitle;
	}

	public String getAccountPageURL() {
		String accPageURL = eleUtil.waitForURLContains(AppConstants.ACCOUNT_PAGE_URL, AppConstants.SHORT_DEFAULT_WAIT);
		return accPageURL;
	}
	
	public boolean myWalletIsVisiable() {
		return eleUtil.waitForVisibilityOfElement(myWalletLink,AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public boolean logoutLinkIsVisiable() {
		return eleUtil.waitForVisibilityOfElement(logoutLink,AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}
}
