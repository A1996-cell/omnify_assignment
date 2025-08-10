package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

public class TestOrangeHRMLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000); 
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        
        Thread.sleep(3000);
        boolean isDashboardVisible = driver.findElements(By.xpath("//h6[text()='Dashboard']")).size() > 0;
        Assert.assertTrue("Login failed: Dashboard not displayed", isDashboardVisible);
        
        Thread.sleep(2000);
        driver.quit();
    }
}
