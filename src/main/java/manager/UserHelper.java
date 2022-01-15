package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
