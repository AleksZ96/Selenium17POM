package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(profilePage.getMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
    }
    @Test
    public void verifyThatUserCanLogOut(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        profilePage.clickOnLogoutButton();
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL );
    }

    @Test
    public void verifyThatUserCantLoginWithInvalidUserNameAndValidPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student1");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test
    public void verifyThatUserCantLoginWithValidUserNameAndInvalidPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password1234");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test
    public void verifyThatUserCantLoginWithValidUserNameAndEmptyPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test
    public void verifyThatUserCantLoginWithEmptyUserNameAndValidPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test
    public void verifyThatUserCantLoginWithEmptyUserNameAndEmptyPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test
    public void verifyThatUserCantLoginWithInvalidUserNameAndInvalidPassword(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student1");
        loginPage.inputPassword("Password1234");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }






}
