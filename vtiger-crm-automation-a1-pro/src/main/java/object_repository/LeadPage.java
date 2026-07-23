package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Leads Module.
 * Covers the list view (create button) and the Create/Edit Lead form.
 * URL: index.php?module=Leads&action=index
 */
public class LeadPage {

	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Lead...']")
	private WebElement createLeadButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "salutationtype")
	private WebElement salutation;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(id = "lead_no")
	private WebElement leadNo;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "designation")
	private WebElement title;

	@FindBy(id = "fax")
	private WebElement fax;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "secondaryemail")
	private WebElement secondaryEmail;

	@FindBy(id = "website")
	private WebElement website;

	@FindBy(id = "annualrevenue")
	private WebElement annualRevenue;

	@FindBy(id = "noofemployees")
	private WebElement noOfEmployees;

	@FindBy(name = "leadsource")
	private WebElement leadSource;

	@FindBy(name = "leadstatus")
	private WebElement leadStatus;

	@FindBy(name = "industry")
	private WebElement industry;

	@FindBy(name = "rating")
	private WebElement rating;

	@FindBy(id = "emailoptout")
	private WebElement emailOptOut;

	// ===== Address Fields =====

	@FindBy(id = "lane")
	private WebElement street;

	@FindBy(id = "pobox")
	private WebElement poBox;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "code")
	private WebElement zipCode;

	@FindBy(id = "country")
	private WebElement country;

	// ===== Description =====

	@FindBy(name = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Last Name")
	private WebElement detailViewLastName;

	// ===== Getters =====

	public WebElement getCreateLeadButton() {
		return createLeadButton;
	}

	public WebElement getSalutation() {
		return salutation;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLeadNo() {
		return leadNo;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSecondaryEmail() {
		return secondaryEmail;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getAnnualRevenue() {
		return annualRevenue;
	}

	public WebElement getNoOfEmployees() {
		return noOfEmployees;
	}

	public WebElement getLeadSource() {
		return leadSource;
	}

	public WebElement getLeadStatus() {
		return leadStatus;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getEmailOptOut() {
		return emailOptOut;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getPoBox() {
		return poBox;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getDetailViewLastName() {
		return detailViewLastName;
	}
}
