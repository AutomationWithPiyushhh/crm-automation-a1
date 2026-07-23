package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Contacts Module.
 * Covers the list view (create button) and the Create/Edit Contact form.
 * URL: index.php?module=Contacts&action=index
 */
public class ContactPage {

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Contact...']")
	private WebElement createContactButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "salutationtype")
	private WebElement salutation;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(id = "contact_no")
	private WebElement contactNo;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(id = "phone")
	private WebElement officePhone;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "title")
	private WebElement title;

	@FindBy(id = "department")
	private WebElement department;

	@FindBy(id = "fax")
	private WebElement fax;

	@FindBy(id = "homephone")
	private WebElement homePhone;

	@FindBy(id = "otherphone")
	private WebElement otherPhone;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "secondaryemail")
	private WebElement secondaryEmail;

	@FindBy(name = "leadsource")
	private WebElement leadSource;

	// ===== Organization Picker =====

	@FindBy(name = "account_id")
	private WebElement organizationName;

	@FindBy(xpath = "//img[contains(@onclick,'module=Accounts') and contains(@onclick,'account_id')]")
	private WebElement organizationPickerIcon;

	// ===== Reports To Picker =====

	@FindBy(name = "contact_id")
	private WebElement reportsTo;

	@FindBy(xpath = "//img[contains(@onclick,'module=Contacts') and contains(@onclick,'contact_id')]")
	private WebElement reportsToPickerIcon;

	// ===== Other Fields =====

	@FindBy(id = "assistant")
	private WebElement assistant;

	@FindBy(id = "assistantphone")
	private WebElement assistantPhone;

	@FindBy(id = "jscal_field_birthday")
	private WebElement birthdate;

	@FindBy(id = "emailoptout")
	private WebElement emailOptOut;

	@FindBy(id = "donotcall")
	private WebElement doNotCall;

	@FindBy(id = "reference")
	private WebElement reference;

	// ===== Address Fields =====

	@FindBy(id = "mailingstreet")
	private WebElement mailingStreet;

	@FindBy(id = "mailingcity")
	private WebElement mailingCity;

	@FindBy(id = "mailingstate")
	private WebElement mailingState;

	@FindBy(id = "mailingzip")
	private WebElement mailingZip;

	@FindBy(id = "mailingcountry")
	private WebElement mailingCountry;

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

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getSalutation() {
		return salutation;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOfficePhone() {
		return officePhone;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getHomePhone() {
		return homePhone;
	}

	public WebElement getOtherPhone() {
		return otherPhone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSecondaryEmail() {
		return secondaryEmail;
	}

	public WebElement getLeadSource() {
		return leadSource;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getOrganizationPickerIcon() {
		return organizationPickerIcon;
	}

	public WebElement getReportsTo() {
		return reportsTo;
	}

	public WebElement getReportsToPickerIcon() {
		return reportsToPickerIcon;
	}

	public WebElement getAssistant() {
		return assistant;
	}

	public WebElement getAssistantPhone() {
		return assistantPhone;
	}

	public WebElement getBirthdate() {
		return birthdate;
	}

	public WebElement getEmailOptOut() {
		return emailOptOut;
	}

	public WebElement getDoNotCall() {
		return doNotCall;
	}

	public WebElement getReference() {
		return reference;
	}

	public WebElement getMailingStreet() {
		return mailingStreet;
	}

	public WebElement getMailingCity() {
		return mailingCity;
	}

	public WebElement getMailingState() {
		return mailingState;
	}

	public WebElement getMailingZip() {
		return mailingZip;
	}

	public WebElement getMailingCountry() {
		return mailingCountry;
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
