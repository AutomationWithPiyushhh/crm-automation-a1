package crm.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.OrganizationPage;

@Listeners(listeners_utility.List_Imp.class)
public class OrgTest extends BaseClass {

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException {

		// Read data from Excel
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0) + JavaUtility.generateRandomNumber();

		// Home Page
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// Organization Page
		OrganizationPage op = new OrganizationPage(driver);

		op.getCreateOrganizationButton().click();

		// Fill Organization Details
		op.getOrganizationName().sendKeys(orgName);
		op.getPhone().sendKeys("9876543210");
		op.getEmail().sendKeys("testorg@vtiger.com");
		op.getWebsite().sendKeys("www.testorg.com");

		// Save
		op.getSaveButton().click();

		// Verification

		String actOrgName = op.getDetailViewOrganizationName().getText();

		Assert.assertEquals(actOrgName, orgName);
	}
}