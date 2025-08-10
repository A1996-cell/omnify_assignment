package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddEmployeePage {
    WebDriver driver;

    By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");
    By saveButton = By.xpath("//button[@type='submit']");
    By empNameSearchInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    By searchButton = By.xpath("//button[@type='submit']");
    By pimLink = By.linkText("PIM");
    By addemployeelink = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By employeelist = By.linkText("Employee List");
    
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String fName, String mName, String lName) {
    	driver.findElement(pimLink).click();
    	driver.findElement(addemployeelink).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(middleName).sendKeys(mName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveButton).click();
    }

    public boolean searchEmployee(String empName) {
    	driver.findElement(employeelist).click();
        driver.findElement(empNameSearchInput).sendKeys(empName);
        driver.findElement(searchButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
        try {
        
			boolean result = driver.findElements(By.xpath("//div[contains(text(), '"+empName+"')]")).size() > 0;
			return result;
        }
        catch (Exception e) {
        	System.out.println("running catch");
		      return false;
		    }
    }
}
