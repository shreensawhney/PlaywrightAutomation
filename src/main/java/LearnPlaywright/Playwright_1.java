package LearnPlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Playwright_1 {
    public static void main(String[] args) {

    Playwright playwright = Playwright.create(); //start PW server
    //Chromium browser in default headed mode.
    //Browser browser =playwright.chromium().launch();  //return a browser
    //Chromium browser in headless
    //Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));  //return a browser
    //Firefox browser in headless
    //  Browser browser =playwright.firefox().launch();  //return a browser

    //Launch chrome Browser
    BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
    lp.setChannel("chrome");
    //lp.setChannel("msedge");
    // lp.setChannel("firefox")

    lp.setHeadless(false);
    Browser browser = playwright.chromium().launch(lp);

    Page page = browser.newPage();
    page.navigate("https://www.amazon.com/");
    String title = page.title();
    System.out.println("page title is " + title);

    String url = page.url();
    System.out.println("page url is " + url);

    browser.close();
    playwright.close();


}
}