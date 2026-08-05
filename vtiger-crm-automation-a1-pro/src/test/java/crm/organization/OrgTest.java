package crm.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.OrganizationPage;

public class OrgTest extends BaseClass {

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException {

		ExtentTest test = report.createTest("Create Organization Test");

		test.log(Status.INFO, "========== Test Execution Started ==========");

		// Read data from Excel
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0)
				+ JavaUtility.generateRandomNumber();

		test.log(Status.INFO, "Organization Name Generated : " + orgName);

		// Home Page
		HomePage hp = new HomePage(driver);
		test.log(Status.INFO, "Navigating to Organizations module");
		hp.getOrganizationsLink().click();

		// Organization Page
		OrganizationPage op = new OrganizationPage(driver);

		test.log(Status.INFO, "Clicking Create Organization button");
		op.getCreateOrganizationButton().click();

		// Fill Organization Details
		test.log(Status.INFO, "Entering Organization Details");

		op.getOrganizationName().sendKeys(orgName);
		op.getPhone().sendKeys("9876543210");
		op.getEmail().sendKeys("testorg@vtiger.com");
		op.getWebsite().sendKeys("www.testorg.com");

		test.log(Status.INFO, "Organization details entered successfully");

		// Save
		test.log(Status.INFO, "Saving the organization");
		op.getSaveButton().click();

		// Verification
		test.log(Status.INFO, "Verifying created organization");

		String actOrgName = op.getDetailViewOrganizationName().getText();

		Assert.assertEquals(actOrgName, orgName);

		test.log(Status.PASS, "Organization created successfully");
		test.log(Status.PASS, "Expected Organization : " + orgName);
		test.log(Status.PASS, "Actual Organization   : " + actOrgName);

		test.log(Status.INFO, "========== Test Execution Completed ==========");
	}
}