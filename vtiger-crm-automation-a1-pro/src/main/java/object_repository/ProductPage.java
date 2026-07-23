package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for the VTiger CRM Products Module.
 * Covers the list view (create button) and the Create/Edit Product form.
 * URL: index.php?module=Products&action=index
 */
public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ===== List View Elements =====

	@FindBy(css = "img[title='Create Product...']")
	private WebElement createProductButton;

	// ===== Create / Edit Form Elements =====

	@FindBy(name = "productname")
	private WebElement productName;

	@FindBy(id = "product_no")
	private WebElement productNo;

	@FindBy(id = "productcode")
	private WebElement productCode;

	@FindBy(id = "vendor_id")
	private WebElement vendorName;

	@FindBy(xpath = "//img[contains(@onclick,'module=Vendors') and contains(@onclick,'vendor_id')]")
	private WebElement vendorPickerIcon;

	@FindBy(id = "mfr_part_no")
	private WebElement mfrPartNo;

	@FindBy(id = "vendor_part_no")
	private WebElement vendorPartNo;

	@FindBy(id = "serial_no")
	private WebElement serialNo;

	@FindBy(id = "product_url")
	private WebElement productUrl;

	@FindBy(id = "qty_per_unit")
	private WebElement qtyPerUnit;

	@FindBy(id = "unit_price")
	private WebElement unitPrice;

	@FindBy(id = "commissionrate")
	private WebElement commissionRate;

	@FindBy(id = "taxclass")
	private WebElement taxClass;

	@FindBy(name = "productcategory")
	private WebElement productCategory;

	@FindBy(id = "reorderlevel")
	private WebElement reorderLevel;

	@FindBy(id = "qtyinstock")
	private WebElement qtyInStock;

	@FindBy(id = "qtyindemand")
	private WebElement qtyInDemand;

	// ===== Description / More Details =====

	@FindBy(id = "description")
	private WebElement description;

	// ===== Save / Cancel Buttons =====

	@FindBy(className = "save")
	private WebElement saveButton;

	@FindBy(className = "cancel")
	private WebElement cancelButton;

	// ===== Detail View Verification =====

	@FindBy(id = "dtlview_Product Name")
	private WebElement detailViewProductName;

	// ===== Getters =====

	public WebElement getCreateProductButton() {
		return createProductButton;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductNo() {
		return productNo;
	}

	public WebElement getProductCode() {
		return productCode;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getVendorPickerIcon() {
		return vendorPickerIcon;
	}

	public WebElement getMfrPartNo() {
		return mfrPartNo;
	}

	public WebElement getVendorPartNo() {
		return vendorPartNo;
	}

	public WebElement getSerialNo() {
		return serialNo;
	}

	public WebElement getProductUrl() {
		return productUrl;
	}

	public WebElement getQtyPerUnit() {
		return qtyPerUnit;
	}

	public WebElement getUnitPrice() {
		return unitPrice;
	}

	public WebElement getCommissionRate() {
		return commissionRate;
	}

	public WebElement getTaxClass() {
		return taxClass;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getReorderLevel() {
		return reorderLevel;
	}

	public WebElement getQtyInStock() {
		return qtyInStock;
	}

	public WebElement getQtyInDemand() {
		return qtyInDemand;
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

	public WebElement getDetailViewProductName() {
		return detailViewProductName;
	}
}
