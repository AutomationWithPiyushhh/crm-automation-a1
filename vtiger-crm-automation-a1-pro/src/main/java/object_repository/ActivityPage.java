package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Activities / Calendar Module.
 * Covers creation of Events (Calls/Meetings) and To-Do items (Tasks).
 * URL: index.php?module=Calendar&action=index
 */
public class ActivityPage {

	public ActivityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Activity...']")
	private WebElement createActivityButton;

	@FindBy(linkText = "Add Event")
	private WebElement addEventLink;

	@FindBy(linkText = "Add Todo")
	private WebElement addTodoLink;

	// ===== Event Form Fields =====

	@FindBy(name = "subject")
	private WebElement subject;

	@FindBy(name = "activitytype")
	private WebElement activityType;

	@FindBy(name = "eventstatus")
	private WebElement eventStatus;

	@FindBy(id = "jscal_field_date_start")
	private WebElement startDate;

	@FindBy(id = "time_start")
	private WebElement startTime;

	@FindBy(id = "due_date")
	private WebElement endDate;

	@FindBy(id = "time_end")
	private WebElement endTime;

	@FindBy(name = "visibility")
	private WebElement visibility;

	@FindBy(id = "location")
	private WebElement location;

	// ===== To-Do (Task) Form Fields =====

	@FindBy(name = "taskpriority")
	private WebElement taskPriority;

	@FindBy(name = "taskstatus")
	private WebElement taskStatus;

	@FindBy(id = "due_date")
	private WebElement dueDate;

	// ===== Contact / Lead Picker (Invitees) =====

	@FindBy(name = "invitees_searchfield")
	private WebElement inviteesSearch;

	// ===== Description =====

	@FindBy(name = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Subject")
	private WebElement detailViewSubject;

	// ===== Getters =====

	public WebElement getCreateActivityButton() {
		return createActivityButton;
	}

	public WebElement getAddEventLink() {
		return addEventLink;
	}

	public WebElement getAddTodoLink() {
		return addTodoLink;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getActivityType() {
		return activityType;
	}

	public WebElement getEventStatus() {
		return eventStatus;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getStartTime() {
		return startTime;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getEndTime() {
		return endTime;
	}

	public WebElement getVisibility() {
		return visibility;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getTaskPriority() {
		return taskPriority;
	}

	public WebElement getTaskStatus() {
		return taskStatus;
	}

	public WebElement getDueDate() {
		return dueDate;
	}

	public WebElement getInviteesSearch() {
		return inviteesSearch;
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

	public WebElement getDetailViewSubject() {
		return detailViewSubject;
	}
}
