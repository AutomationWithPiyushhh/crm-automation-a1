package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Home/Dashboard Page.
 * Represents the navigation bar and user profile elements visible after login.
 */
public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== Top Navigation Links =====

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Activities")
	private WebElement activitiesLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "Quotes")
	private WebElement quotesLink;

	@FindBy(linkText = "Invoices")
	private WebElement invoicesLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;

	@FindBy(linkText = "Cases")
	private WebElement casesLink;

	// ===== Profile / Logout Elements =====

	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	// ===== Getters for Navigation Links =====

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getActivitiesLink() {
		return activitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getInvoicesLink() {
		return invoicesLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getCasesLink() {
		return casesLink;
	}

	// ===== Getters for Profile / Logout =====

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
}
