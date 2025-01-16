import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void testSuccessLogin() {
        // Add username
        loginPage.addUserName("Admin");
        // Add password
        loginPage.addPassword("admin123");
        //  Click login
        loginPage.clickLoginButton();
    }

}
