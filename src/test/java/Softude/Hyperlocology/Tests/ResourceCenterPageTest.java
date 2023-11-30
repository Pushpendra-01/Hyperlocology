package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.BrandUserPage;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.ResourceCenterPage;

public class ResourceCenterPageTest extends BaseTest {

	@Test
	public void addEducationalVedios() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		ResourceCenterPage resourceCenterPage=editBrand.goToResourceCenterPage();
		resourceCenterPage.addEducationalVedios("TestingVedioTitle", "https://www.youtube.com/watch?v=_Z0ZQT0FttM&ab_channel=MsRachel-ToddlerLearningVideos");
		
	}
}
