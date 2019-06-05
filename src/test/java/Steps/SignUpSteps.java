package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignUpSteps {
    WebDriver driver;
    @Before
    public void beginTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Kasi Raj\\IdeaProjects\\Selenium\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("User is in signup page of Learnyst website")
    public void userIsInSignupPageOfLearnystWebsite() {
        driver.get("https://ibbuali.learnyst.com/");
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.xpath("//p[contains(text(),\"TRY NOW FOR FREE\")]/parent::button"));
        login.click();
        driver.manage().timeouts().implicitlyWait(5l,TimeUnit.SECONDS);
//        driver.findElement(By.id("simpleHeader_new_user_signup-btn")).isDisplayed();
    }

 

    @Then("User is signed up and home page is shown")
    public void userIsSignedUpAndHomePageIsShown() {
        if(driver.findElement(By.xpath("//span[contains(text(),\"Welcome to Ibrahim Ali Khan LNU. Happy Learning!\")]")).isDisplayed())
            System.out.println("Test passed");
        else
            System.out.println("Test Failed");
    }

    @When("User fills signup form with valid data")
    public void userFillsSignupFormWithValidData(DataTable table) {
        List<String> data = table.asList(String.class);
        driver.findElement(By.id("simpleHeader_new_user_user_email")).sendKeys(data.get(2));
        driver.findElement(By.id("simpleHeader_new_user_user_password")).sendKeys(data.get(3));
        driver.findElement(By.id("simpleHeader_new_user_signup-btn")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @After
    public void exitBrowser(){
        driver.close();
        driver.quit();
    }

    @When("User clicks signup using facebook")
    public void userClicksSignupUsingFacebook() {
        driver.findElement(By.xpath("//button[text()=\" Signup with facebook \"]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Set<String> currentWindows = driver.getWindowHandles();
        String[] windows = new String[currentWindows.size()];
        int i=0;
        for(String window:currentWindows){
            windows[i] = window;
            i++;
        }
        driver.switchTo().window(windows[1]);
        driver.findElement(By.id("email")).sendKeys("kasiraj@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("u_0_0")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.switchTo().window(windows[0]);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @And("User gives permission to use facebook information")
    public void userGivesPermissionToUseFacebookInformation() {
    }
}
