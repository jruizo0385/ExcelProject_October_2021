package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_ON_PROFILE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a")
	WebElement PROFILE_CUSTOMER_ELEMENT;
	
	public void verifyAddContactPage(){
		waitForElement(driver, 5, ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Wrong page!!!");
	}
	
	String insertedName; 
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandom(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		String insertedEmail = generateRandom(999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
		
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandom(999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountryFromDropdown(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
	
	public void verifyProfilePage() {
		waitForElement(driver, 3, SUMMARY_ON_PROFILE_ELEMENT);
		Assert.assertEquals(SUMMARY_ON_PROFILE_ELEMENT.getText(), "Summary", "Wrong Page!!");
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
	
	public void verifyEnteredNameAndDelete() {
		
		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			String name = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
//			System.out.println(name);
			if(name.contains(insertedName)) {
				System.out.println("Inserted name exist.");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
		}
	}
	
	
	
}
