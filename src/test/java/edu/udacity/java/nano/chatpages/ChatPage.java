package edu.udacity.java.nano.chatpages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;


@PageUrl("http://localhost:8080/index?username=userOne")

public class ChatPage extends FluentPage {

    @FindBy(id = "msg")
    private FluentWebElement msgInput;

    @FindBy(xpath= "//button[1]")
    private FluentList<FluentWebElement> sendButton;

    public void enterMessage(){
        msgInput.fill().with("Hello");
    }
    public void sendButtonClick(){
        sendButton.click();
    }

}