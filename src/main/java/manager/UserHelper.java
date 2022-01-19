package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLogRegForm(){

        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String email, String password){

        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"),password);

    }

    public void fillLoginForm(User user){

        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());

    }
    public void submitLoginForm(){
        click(By.xpath("//*[text()=' Login']"));
    }

    public void submitRegForm(){
        click(By.xpath("//*[text()=' Registration']"));
    }

    public void fillRegistrationForm(String email, String password){

        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"),password);

    }

    public void fillRegistrationForm(User user){

        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());

    }

    public boolean isRegistrSuccess() {

        WebDriverWait wait = new WebDriverWait(wd,5);
        wait.until(ExpectedConditions.urlToBe("https://contacts-app.tobbymarshall815.vercel.app/contacts"));

        WebElement message = wd.findElement(By.cssSelector(".contact-page_message__2qafk"));

        return message.isDisplayed();
    }

    public boolean isLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(wd,5);
        wait.until(ExpectedConditions.urlToBe("https://contacts-app.tobbymarshall815.vercel.app/contacts"));

        WebElement message = wd.findElement(By.cssSelector("button"));
        String text = message.getText();

        return text.equals("Sign Out");
    }
}
