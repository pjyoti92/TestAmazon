package com.jyoti.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Class include all the elements of the class
 * @author Jyoti Pareek
 *
 */
public class Elements {

	public Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='desktop-1']//div[@class='a-section as-title-block']//span[@class='a-color-base']")
	static WebElement TodayDealText;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "See all deals")
	static WebElement SeeAllDealsLink;

	@FindBy(how = How.XPATH, using = "//a[@class='a-popover-trigger a-declarative deal_popover_link']")
	static WebElement Category;

	@FindBy(how = How.XPATH, using = "//a[@class='a-link-normal deal_popover_link']//span[.='Beauty']")
	static WebElement Beauty;

	@FindBy(how = How.XPATH, using = "//a[@class='a-link-normal deal_popover_link']//span[.='Baby']")
	static WebElement Baby;

	@FindBy(how = How.XPATH, using = "//a[@id='nav-link-yourAccount']")
	static WebElement SignIn;

	@FindBy(how = How.XPATH, using = "//input[@id='ap_email']")
	static WebElement UserId;

	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	static WebElement Continue;

	@FindBy(how = How.XPATH, using = "//input[@id='ap_password']")
	static WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='signInSubmit']")
	static WebElement Submit;

	@FindBy(how = How.XPATH, using = "//a[@id='nav-link-yourAccount']//span[@class='nav-line-1']")
	static WebElement UserDetails;

}
