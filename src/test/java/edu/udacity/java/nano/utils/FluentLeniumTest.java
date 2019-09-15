package edu.udacity.java.nano.utils;

import org.apache.commons.exec.OS;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.BeforeClass;

import java.io.File;
import java.util.Objects;


public class FluentLeniumTest extends FluentTest {

    private static MyProperties myProperties = new MyProperties();

    @BeforeClass
    public static void setUp() {
        String driverName = myProperties.getProperty("driver");
        String driverPathWindows="C:\\Users\\Nafeez Quraishi\\IdeaProjects\\chatroom-starter\\src\\main\\resources\\chromedriver.exe";
        String driverPathUnix="C:\\Users\\Nafeez Quraishi\\IdeaProjects\\chatroom-starter\\src\\main\\resources\\chromedriver";
        switch(driverName){
            case "chrome":
                //chrome driver loaded from src->main->resources
                if (OS.isFamilyWindows()){
                    System.setProperty("webdriver.chrome.driver", driverPathWindows);
                }
                else if (OS.isFamilyUnix()){
                    System.setProperty("webdriver.chrome.driver", driverPathUnix);
                }

                break;

//            case "mozilla":
                //Solution can be extended to cover more browser types

            default:
                System.out.println("No driver selected");
                break;
        }

    }

    @Override
    public String getWebDriver() {
        return myProperties.getProperty("driver");
    }

}