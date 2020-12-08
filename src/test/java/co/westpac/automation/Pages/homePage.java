package co.westpac.automation.Pages;

import WebConnector.*;
import com.sun.media.sound.InvalidFormatException;

import static WebConnector.webConnector.driver;

import java.io.IOException;

public class homePage {
    webConnector wc = new webConnector();
    private String MenuKiwiSaver = "xpath, //*[@id=\'ubermenu-section-link-kiwisaver-ps\']";
    private String MenuKiwiSaverCalculators = "xpath,  //*[@id=\'ubermenu-item-cta-kiwisaver-calculators-ps\']";

    public void goToHomePage() throws InvalidFormatException, IOException {
        String URL = "https://www.westpac.co.nz";
        driver.get(URL);
        wc.waitForCondition("PageLoad", "", 8860);
    }

    public void clickKiwiSaverCalculator() {
        try {
            wc.ClickLinkFromHover(MenuKiwiSaver, MenuKiwiSaverCalculators);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
