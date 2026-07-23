package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Vendors Module.
 * Covers the list view (create button) and the Create/Edit Vendor form.
 * URL: index.php?module=Vendors&action=index
 */
public class VendorPage {

	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Vendor...']")
	private WebElement createVendorButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "vendorname")
	private WebElement vendorName;

	@FindBy(id = "vendor_no")
	private WebElement vendorNo;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "website")
	private WebElement website;

	@FindBy(id = "fax")
	private WebElement fax;

	@FindBy(id = "glacct")
	private WebElement glAccount;

	// ===== Address Fields =====

	@FindBy(id = "street")
	private WebElement street;

	@FindBy(id = "pobox")
	private WebElement poBox;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "postalcode")
	private WebElement postalCode;

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

	@FindBy(id = "dtlview_Vendor Name")
	private WebElement detailViewVendorName;

	// ===== Getters =====

	public WebElement getCreateVendorButton() {
		return createVendorButton;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getVendorNo() {
		return vendorNo;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getGlAccount() {
		return glAccount;
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

	public WebElement getPostalCode() {
		return postalCode;
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

	public WebElement getDetailViewVendorName() {
		return detailViewVendorName;
	}
}
