package com.wundermobility.fastip.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wundermobility.pages.fastip.LandingPAge;
import com.wundermobility.utility.fastip.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyTotalBillValue extends Base {
	AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		service = startServer();
		startEmulator();
		driver = launchDriver();
	}

	@Test
	public void VerifyTipAmountAndTotalBillAmount() throws InterruptedException {
		int amount = 10;
		LandingPAge landPage = new LandingPAge(driver);
		double expectedTipAmount = landPage.getTipAmount(amount);
		double expectedtotalBillValue = landPage.getTotalAmount(amount);
		landPage.enterBillAmount(amount);
		landPage.clickCalculateTip();
		double actualTipAmount = Double.parseDouble(landPage.getTipValue());
		double actualtotalBillValue = Double.parseDouble(landPage.getTotalValue());
		Assert.assertEquals(actualTipAmount, expectedTipAmount,
				"Tip amount value didnt match  Expected: " + expectedTipAmount + " Actual :" + actualTipAmount);
		Assert.assertEquals(actualtotalBillValue, expectedtotalBillValue, "Total bill value didnt match  Expected: "
				+ expectedtotalBillValue + " Actual :" + actualtotalBillValue);
	}

	@AfterClass
	public void afterClass() {
		service.stop();
	}
}
