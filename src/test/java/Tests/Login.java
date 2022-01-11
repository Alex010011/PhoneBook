package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    WebDriver wd;


    @BeforeMethod
    public void preconditions(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }

    @Test
    public void loginSuccessTest(){

       // int index = (int)(System.currentTimeMillis()/1000)%3600;


        click(By.cssSelector("[href= '/login']"));
        type(By.cssSelector("[placeholder='Email']"), "mastertest@gmai.com");
        type(By.cssSelector("[placeholder='Password']"), "masterTest1@");
        click(By.cssSelector("div button:first-of-type"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }


   // @AfterMethod
  //  public void postconditions(){

      //  wd.close();
      //  wd.quit();
  //  }

}
