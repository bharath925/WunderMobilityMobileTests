package com.wundermobility.pages.fastip;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage {

	WebDriverWait wait;

	public SettingsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 15);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.traeg.fastip:id/menu_settings']")
	public WebElement settings_BT; // BT: button

	@AndroidFindBy(xpath = "//android.widget.EditText[@class='android.widget.EditText']")
	public WebElement percentageValue_EB; // EB: Edit Box

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='org.traeg.fastip:id/saveSettingsButton']")
	public WebElement save_BT;// BT: button

	public void updatePercentageValue(String percentage) {
		settings_BT.click();
		wait.until(ExpectedConditions.visibilityOf(percentageValue_EB));
		percentageValue_EB.clear();
		percentageValue_EB.sendKeys(percentage + "");
		save_BT.click();
	}

}
