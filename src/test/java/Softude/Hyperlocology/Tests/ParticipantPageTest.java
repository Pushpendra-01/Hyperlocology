package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.ParticipantsPage;


 public class ParticipantPageTest extends BaseTest{
 @Test
 public void validateAdvanceSearch() {
    ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	ParticipantsPage participantsPage=parentCompanies.goToParticipantPage();
	participantsPage.advanceSearchValidation("John Devex", "Y82QL", "Active");
 }
 @Test
 public void getParticipantName() {
	ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	ParticipantsPage participantsPage=parentCompanies.goToParticipantPage();
	participantsPage.getParticipantsNameOfTheBrand("Astor-martin");
 }
	
}
