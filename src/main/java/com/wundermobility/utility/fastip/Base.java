package com.wundermobility.utility.fastip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	// Starts the appium server
	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunnning(4723);// Default Port.
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
			service = AppiumDriverLocalService.buildDefaultService();
		} finally {
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\resources\\startEmulator.bat");
		Thread.sleep(10000);
	}

	public static AndroidDriver<AndroidElement> launchDriver() throws IOException, InterruptedException {
		FileInputStream properties = new FileInputStream(
				System.getProperty("user.dir") + "\\resources\\global.properties");
		Properties gei = new Properties();
		gei.load(properties);
		File app = new File(System.getProperty("user.dir"), "\\resources\\" + gei.getProperty("AUT"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = gei.getProperty("device");

		if (device.contains("emulator")) {
			startEmulator();
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
