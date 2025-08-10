package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.AddEmployeePage;
import utils.DriverManager;

public class OrangeHRMTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Thread.sleep(3000);

        AddEmployeePage addEmp = new AddEmployeePage(driver);
        addEmp.addEmployee("Amika", "", "Kapoor");

        Thread.sleep(3000); // wait for add to complete

        boolean pass = addEmp.searchEmployee("Amika");
        if(pass) {
        	System.out.println("Name Verified");
        }else {
        	System.out.println("Employee not added");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}

