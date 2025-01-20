import Pages.DashboardPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {

    //TC1
    @Test
    public void testSuccessLogin() {
        // Add username
        loginPage.addUserName("Admin");
        // Add password
        loginPage.addPassword("admin123");
        //  Click login
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        //assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(dashboardPage.isDashboardIconVisible());
    }

    //TC2
    @Test
    public void testInvalidUsername() {
        loginPage.addUserName("as");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isInvalidErrorMsgVisible());
    }

    //TC3
    @Test
    public void testInvalidPassword() {
        loginPage.addUserName("Admin");
        loginPage.addPassword("test");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isInvalidErrorMsgVisible());
    }

    //TC4
    @Test
    public void testEmptyUsername() {
        loginPage.addUserName("");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMsgVisible());
    }

    //TC5
    @Test
    public void testEmptyPassword() {
        loginPage.addUserName("Admin");
        loginPage.addPassword("");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMsgVisible());
    }

    //TC6
    @Test
    public void testEmptyUsernameAndPassword() {
        loginPage.addUserName("");
        loginPage.addPassword("");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isDuplicateRequiredMsgVisible());
    }
}
