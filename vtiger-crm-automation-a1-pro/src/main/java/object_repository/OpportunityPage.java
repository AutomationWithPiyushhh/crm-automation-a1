package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Opportunities (Potentials) Module.
 * Covers the list view (create button) and the Create/Edit Opportunity form.
 * URL: index.php?module=Potentials&action=index
 */
public class OpportunityPage {

	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Opportunity...']")
	private WebElement createOpportunityButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "potentialname")
	private WebElement opportunityName;

	@FindBy(id = "potential_no")
	private WebElement potentialNo;

	@FindBy(name = "amount")
	private WebElement amount;

	@FindBy(id = "jscal_field_closingdate")
	private WebElement closingDate;

	@FindBy(xpath = "//img[contains(@onclick, 'srcmodule=Potentials')]")
	private WebElement relatedTo;

	@FindBy(name = "opportunity_type")
	private WebElement opportunityType;

	@FindBy(name = "leadsource")
	private WebElement leadSource;

	@FindBy(name = "sales_stage")
	private WebElement salesStage;

	@FindBy(id = "probability")
	private WebElement probability;

	@FindBy(id = "campaignid")
	private WebElement campaign;

	// ===== Organization Picker (Related To) =====

	@FindBy(xpath = "//img[contains(@onclick,'module=Potential') and contains(@onclick,'related_to')]")
	private WebElement relatedToPickerIcon;

	// ===== Description =====

	@FindBy(name = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement detailViewOpportunityName;

	// ===== Getters =====

	public WebElement getCreateOpportunityButton() {
		return createOpportunityButton;
	}

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getPotentialNo() {
		return potentialNo;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getClosingDate() {
		return closingDate;
	}

	public WebElement getRelatedTo() {
		return relatedTo;
	}

	public WebElement getOpportunityType() {
		return opportunityType;
	}

	public WebElement getLeadSource() {
		return leadSource;
	}

	public WebElement getSalesStage() {
		return salesStage;
	}

	public WebElement getProbability() {
		return probability;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getRelatedToPickerIcon() {
		return relatedToPickerIcon;
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

	public WebElement getDetailViewOpportunityName() {
		return detailViewOpportunityName;
	}
}
