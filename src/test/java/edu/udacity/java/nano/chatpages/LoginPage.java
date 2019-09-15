package edu.udacity.java.nano.chatpages;

import org.assertj.core.api.Assertions;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


@PageUrl("http://localhost:8080/")

public class LoginPage extends FluentPage {

    @FindBy(id = "username")
    private FluentWebElement userName;

    @FindBy(className = "mb2")
    private FluentWebElement loginButton;

    public void enterUserName(){
        userName.fill().with("UserOne");
    }
    public void loginButtonClick(){
        loginButton.click();
    }

}