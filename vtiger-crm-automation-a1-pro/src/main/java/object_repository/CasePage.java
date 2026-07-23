package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Cases / Trouble Tickets Module.
 * Covers the list view (create button) and the Create/Edit Case (Ticket) form.
 * URL: index.php?module=HelpDesk&action=index
 */
public class CasePage {

	public CasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Ticket...']")
	private WebElement createCaseButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "ticket_title")
	private WebElement ticketTitle;

	@FindBy(id = "ticket_no")
	private WebElement ticketNo;

	@FindBy(name = "ticketstatus")
	private WebElement ticketStatus;

	@FindBy(name = "ticketpriorities")
	private WebElement ticketPriority;

	@FindBy(name = "ticketseverities")
	private WebElement ticketSeverity;

	@FindBy(name = "product_id")
	private WebElement productName;

	// ===== Contact/Account Picker =====

	@FindBy(name = "parent_id")
	private WebElement relatedTo;

	@FindBy(xpath = "//img[contains(@onclick,'module=Contacts') and contains(@onclick,'parent_id')]")
	private WebElement contactPickerIcon;

	// ===== Description / Solution =====

	@FindBy(name = "description")
	private WebElement description;

	@FindBy(name = "solution")
	private WebElement solution;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Title")
	private WebElement detailViewTitle;

	// ===== Getters =====

	public WebElement getCreateCaseButton() {
		return createCaseButton;
	}

	public WebElement getTicketTitle() {
		return ticketTitle;
	}

	public WebElement getTicketNo() {
		return ticketNo;
	}

	public WebElement getTicketStatus() {
		return ticketStatus;
	}

	public WebElement getTicketPriority() {
		return ticketPriority;
	}

	public WebElement getTicketSeverity() {
		return ticketSeverity;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getRelatedTo() {
		return relatedTo;
	}

	public WebElement getContactPickerIcon() {
		return contactPickerIcon;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSolution() {
		return solution;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getDetailViewTitle() {
		return detailViewTitle;
	}
}
