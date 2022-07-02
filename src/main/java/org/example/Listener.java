package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        System.out.printf("%s clicked\n", element.getText());
    }

    @Override
    public void afterClick(WebElement element) {

    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.printf("%s send keys\n", element.getText());
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {

    }
}
