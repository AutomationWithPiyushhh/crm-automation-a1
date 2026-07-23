package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Campaigns Module.
 * Covers the list view (create button) and the Create/Edit Campaign form.
 * URL: index.php?module=Campaigns&action=index
 */
public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Campaign...']")
	private WebElement createCampaignButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "campaignname")
	private WebElement campaignName;

	@FindBy(id = "campaign_no")
	private WebElement campaignNo;

	@FindBy(name = "campaigntype")
	private WebElement campaignType;

	@FindBy(name = "campaignstatus")
	private WebElement campaignStatus;

	@FindBy(id = "start_date")
	private WebElement startDate;

	@FindBy(id = "end_date")
	private WebElement endDate;

	@FindBy(id = "closingdate")
	private WebElement closingDate;

	@FindBy(id = "budget")
	private WebElement budget;

	@FindBy(id = "expectedcost")
	private WebElement expectedCost;

	@FindBy(id = "actualcost")
	private WebElement actualCost;

	@FindBy(id = "expectedrevenue")
	private WebElement expectedRevenue;

	@FindBy(id = "actualrevenue")
	private WebElement actualRevenue;

	@FindBy(id = "expectedresponsecount")
	private WebElement expectedResponseCount;

	@FindBy(name = "currency_id")
	private WebElement currency;

	@FindBy(name = "frequency")
	private WebElement frequency;

	// ===== Description =====

	@FindBy(name = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Campaign Name")
	private WebElement detailViewCampaignName;

	// ===== Getters =====

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignNo() {
		return campaignNo;
	}

	public WebElement getCampaignType() {
		return campaignType;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getClosingDate() {
		return closingDate;
	}

	public WebElement getBudget() {
		return budget;
	}

	public WebElement getExpectedCost() {
		return expectedCost;
	}

	public WebElement getActualCost() {
		return actualCost;
	}

	public WebElement getExpectedRevenue() {
		return expectedRevenue;
	}

	public WebElement getActualRevenue() {
		return actualRevenue;
	}

	public WebElement getExpectedResponseCount() {
		return expectedResponseCount;
	}

	public WebElement getCurrency() {
		return currency;
	}

	public WebElement getFrequency() {
		return frequency;
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

	public WebElement getDetailViewCampaignName() {
		return detailViewCampaignName;
	}
}
