package edu.udacity.java.nano.chattests;

import edu.udacity.java.nano.chatpages.ChatPage;
import edu.udacity.java.nano.chatpages.LoginPage;
import edu.udacity.java.nano.utils.FluentLeniumTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.wait.FluentWait;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class AllTests extends FluentLeniumTest {

    @Page
    private LoginPage loginPage;

    @Page
    private ChatPage chatPage;

    @Test
    public void doLogin() throws InterruptedException {
        loginPage.go();
        loginPage.enterUserName();
        loginPage.loginButtonClick();

    }

    @Test
    public void newChat() throws InterruptedException {
        doLogin();
        chatPage.enterMessage();
        chatPage.sendButtonClick();
    }

    @Test
    public void quit() throws InterruptedException {
        doLogin();
        chatPage.window().close();
    }

    @Override
    public FluentWait await() {
        return super.await().atMost(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
    }



}


