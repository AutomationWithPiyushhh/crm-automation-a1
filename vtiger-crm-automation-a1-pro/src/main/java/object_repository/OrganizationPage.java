package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Organization (Accounts) Module.
 * Covers the list view (create button) and the Create/Edit Organization form.
 * URL: index.php?module=Accounts&action=index
 *
 * NOTE: Field IDs/names verified against actual VTiger 5 CRM form.
 */
public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createOrganizationButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "accountname")
	private WebElement organizationName;

	@FindBy(id = "account_no")
	private WebElement accountNo;

	@FindBy(id = "phone")
	private WebElement phone;

	// website has no id — use name attribute
	@FindBy(name = "website")
	private WebElement website;

	@FindBy(id = "fax")
	private WebElement fax;

	@FindBy(id = "tickersymbol")
	private WebElement tickerSymbol;

	@FindBy(id = "otherphone")
	private WebElement otherPhone;

	// email1 and email2 have actual ids
	@FindBy(id = "email1")
	private WebElement email;

	@FindBy(id = "email2")
	private WebElement otherEmail;

	@FindBy(id = "employees")
	private WebElement employees;

	@FindBy(id = "ownership")
	private WebElement ownership;

	// annual_revenue has no id — use name
	@FindBy(name = "annual_revenue")
	private WebElement annualRevenue;

	@FindBy(id = "siccode")
	private WebElement sicCode;

	@FindBy(name = "industry")
	private WebElement industry;

	@FindBy(name = "rating")
	private WebElement rating;

	@FindBy(name = "accounttype")
	private WebElement accountType;

	@FindBy(name = "emailoptout")
	private WebElement emailOptOut;

	// ===== Member Of (Parent Organization) =====
	// account_name field is a text box for org lookup
	@FindBy(name = "account_name")
	private WebElement memberOf;

	// ===== Billing Address Fields =====
	// bill_street is a TEXTAREA with name="bill_street"
	@FindBy(name = "bill_street")
	private WebElement billingStreet;

	@FindBy(id = "bill_city")
	private WebElement billingCity;

	@FindBy(id = "bill_state")
	private WebElement billingState;

	@FindBy(id = "bill_code")
	private WebElement billingCode;

	@FindBy(id = "bill_country")
	private WebElement billingCountry;

	// ===== Shipping Address Fields =====
	// ship_street is a TEXTAREA with name="ship_street"
	@FindBy(name = "ship_street")
	private WebElement shippingStreet;

	@FindBy(id = "ship_city")
	private WebElement shippingCity;

	@FindBy(id = "ship_state")
	private WebElement shippingState;

	@FindBy(id = "ship_code")
	private WebElement shippingCode;

	@FindBy(id = "ship_country")
	private WebElement shippingCountry;

	// ===== Description (TEXTAREA) =====
	@FindBy(name = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====
	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====
	@FindBy(id = "dtlview_Organization Name")
	private WebElement detailViewOrganizationName;

	// ===== Getters =====

	public WebElement getCreateOrganizationButton() { return createOrganizationButton; }
	public WebElement getOrganizationName() { return organizationName; }
	public WebElement getAccountNo() { return accountNo; }
	public WebElement getPhone() { return phone; }
	public WebElement getWebsite() { return website; }
	public WebElement getFax() { return fax; }
	public WebElement getTickerSymbol() { return tickerSymbol; }
	public WebElement getOtherPhone() { return otherPhone; }
	public WebElement getEmail() { return email; }
	public WebElement getOtherEmail() { return otherEmail; }
	public WebElement getEmployees() { return employees; }
	public WebElement getOwnership() { return ownership; }
	public WebElement getAnnualRevenue() { return annualRevenue; }
	public WebElement getSicCode() { return sicCode; }
	public WebElement getIndustry() { return industry; }
	public WebElement getRating() { return rating; }
	public WebElement getAccountType() { return accountType; }
	public WebElement getEmailOptOut() { return emailOptOut; }
	public WebElement getMemberOf() { return memberOf; }
	public WebElement getBillingStreet() { return billingStreet; }
	public WebElement getBillingCity() { return billingCity; }
	public WebElement getBillingState() { return billingState; }
	public WebElement getBillingCode() { return billingCode; }
	public WebElement getBillingCountry() { return billingCountry; }
	public WebElement getShippingStreet() { return shippingStreet; }
	public WebElement getShippingCity() { return shippingCity; }
	public WebElement getShippingState() { return shippingState; }
	public WebElement getShippingCode() { return shippingCode; }
	public WebElement getShippingCountry() { return shippingCountry; }
	public WebElement getDescription() { return description; }
	public WebElement getSaveButton() { return saveButton; }
	public WebElement getCancelButton() { return cancelButton; }
	public WebElement getDetailViewOrganizationName() { return detailViewOrganizationName; }
}
