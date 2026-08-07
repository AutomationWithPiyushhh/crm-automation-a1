package crm.opportunity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import junit.framework.Assert;
import object_repository.HomePage;
import object_repository.OpportunityPage;

/**
 * Test Script: Create Opportunity Test using POM design pattern. Steps: 1.
 * Login to VTiger CRM 2. Navigate to Opportunities module 3. Click Create
 * Opportunity 4. Fill in the opportunity form (name, closing date, amount,
 * sales stage) 5. Select related organization via popup window 6. Save and
 * verify 7. Logout
 */

@Listeners(listeners_utility.List_Imp.class)
public class OppTest extends BaseClass {

	@Test
	public void createOppTest() throws EncryptedDocumentException, IOException {
//		========== POM: HomePage ==========
		HomePage hp = new HomePage(driver);
		hp.getOpportunitiesLink().click();

//		========== POM: OpportunityPage ==========
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOpportunityButton().click();

//		fill the Create Opportunity form
		FileUtility fUtil = new FileUtility();
		String oppName = fUtil.getDataFromExcelFile("opp", 2, 0); 
		
		op.getOpportunityName().sendKeys(oppName);
		op.getAmount().sendKeys("75000");
		op.getClosingDate().sendKeys("12/31/2026");

//		select sales stage
		Select stageSelect = new Select(op.getSalesStage());
		stageSelect.selectByVisibleText("Prospecting");

//		select opportunity type
		Select typeSelect = new Select(op.getOpportunityType());
		typeSelect.selectByVisibleText("Existing Business");

//		select lead source
		Select lsSelect = new Select(op.getLeadSource());
		lsSelect.selectByVisibleText("Web Site");

//		select related organization via popup
//		step 1: store the parent window handle
		String parentWindowHandle = driver.getWindowHandle();

//		step 2: click the Related To picker icon
		op.getRelatedToPickerIcon().click();

//		step 3: switch to popup window
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.switchToWindowByUrl("Accounts");

//		step 4: select an organization (click any partial link to vtiger)
		driver.findElement(By.partialLinkText("Vtiger353")).click();

//		step 5: switch back to parent window
		driver.switchTo().window(parentWindowHandle);

//		save the record
		op.getSaveButton().click();

//		verification
		String actOppName = op.getDetailViewOpportunityName().getText();
		Assert.assertEquals(oppName, actOppName+"abc");

	}
}
