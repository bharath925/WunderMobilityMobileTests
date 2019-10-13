package com.wundermobility.pages.fastip;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPAge {

	public LandingPAge(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Bill Amount']")
	public WebElement billAmount_EB; // EB: Edit Box

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Calculate Tip']")
	public WebElement calculateTip_BT; // BT: button

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.traeg.fastip:id/tipAmtTextView']")
	public WebElement tipValue_DT; // Dyanamic Text

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.traeg.fastip:id/totalAmtTextView']")
	public WebElement totalValue_DT; // Dyanamic Text

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.traeg.fastip:id/tipPctTextView']")
	public WebElement percentageValue_DT; // Dyanamic Text

	public void enterBillAmount(int amount) {
		billAmount_EB.clear();
		billAmount_EB.sendKeys(amount + "");
	}

	public void clickCalculateTip() {
		calculateTip_BT.click();
	}

	public String getTipValue() {
		return tipValue_DT.getText().replace("$", "");
	}

	public String getTotalValue() {
		return totalValue_DT.getText().replace("$", "");
	}

	public double getPercentageValue() {
		return Double.parseDouble(percentageValue_DT.getText().replace("%", ""));
	}

	public double getTipAmount(int amount) {
		return amount * (getPercentageValue() / 100);

	}

	public double getTotalAmount(int amount) {
		return amount + getTipAmount(amount);
	}
}
