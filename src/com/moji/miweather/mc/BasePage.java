package com.moji.miweather.mc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {

	// public abstract void doSth();
	public static AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "mojiweather-V6.0102.02-20161102-release-5019.apk");

		// 判断apk是否存在
		if (!app.exists()) {
			System.out.println("本次需要安装的apk不存在");
		}

		// 设置启动参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// support Chinese
		capabilities.setCapability("unicodekeyboard", "True");
		capabilities.setCapability("resetkeyboard", "True");
		// no need sign
		capabilities.setCapability("noSign", "True");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		// if no need install don't add this
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.moji.mjweather");
		capabilities.setCapability("app-activity", "com.moji.activity.LauncherActivity");// MainActivity
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// 设置隐式等待超时时间
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// 滑动新手教程
	public void swipes(AndroidDriver<WebElement> driver, int number) throws InterruptedException, IOException {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		Thread.sleep(5000);
		for (int i = 0; i < number; i++) {
			driver.swipe(width * 13 / 16, height / 2, width / 16, height / 2, 1500);
			Thread.sleep(1000);
			System.out.println("第" + (i + 1) + "次滑动完成");
		}
		System.out.println("新手教程滑动完成");
	}

	// 6.0新手教程
	public void newTutorial() throws InterruptedException {
		Thread.sleep(2000);
		swipeToLeft(driver, 1000);
		driver.findElement(By.id("com.moji.mjweather:id/cb_checkbox")).click();
		swipeToLeft(driver, 1000);
		driver.findElement(By.id("com.moji.mjweather:id/iv_enter_moji")).click();
		Thread.sleep(2000);
		driver.findElementById("com.moji.mjweather:id/ll_main_weather").click();
	}

	// 屏幕滑动
	/**
	 * 向上滑动屏幕
	 * 
	 * @param driver
	 * @param during
	 *            during value about 1000,too small will arise only click and
	 *            swipe failed
	 */

	public void swipeToUp(AndroidDriver<WebElement> driver, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		// 取1/4屏宽，取1/2会点到时景页面相机，无法向上滑动
		driver.swipe(width / 4, height * 13 / 16, width / 4, height / 16, during);
	}

	/**
	 * 向下滑动
	 * 
	 * @param driver
	 * @param during
	 */
	public void swipeToDown(AndroidDriver<WebElement> driver, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		// height改成3/16，否则向下滑动时，第一个落点在底部Title栏，导致向下滑动失败
		driver.swipe(width / 2, height * 3 / 16, width / 2, height * 13 / 16, during);
		// wait for page loading
	}

	// 向左
	public void swipeToLeft(AndroidDriver<WebElement> driver, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width * 13 / 16, height / 2, width / 16, height / 2, during);
		// wait for page loading
	}

	// 向右
	public void swipeToRight(AndroidDriver<WebElement> driver, int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 16, height / 2, width * 13 / 16, height / 2, during);
		// wait for page loading
	}

	// 分享
	public void share(AndroidDriver<WebElement> driver) throws InterruptedException {
		driver.findElement(By.id("com.moji.mjweather:id/share_iv")).click();
		snapshot((TakesScreenshot) driver, "调起分享页面.png");
		Thread.sleep(10000);
	}

	// 截屏图片
	/**
	 * 截屏 1.将相应页面截下来保存到指定磁盘位置
	 * 
	 * @param drivername
	 * @param filename
	 */
	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		String currentPath = System.getProperty("user.dir"); // get current work
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);

		try {
			System.out.println("save snapshot path is:" + currentPath + "/" + filename);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished, it's in " + currentPath + " folder");
		}
	}

	// 录制MP4
	/**
	 * 录制 1.录制MP4格式的视频文件，将所有操作记录下来
	 * 
	 * @throws IOException
	 */
	public void startRecord() throws IOException {
		Runtime rt = Runtime.getRuntime();
		// this code for record the screen of your device
		rt.exec("cmd.exe /C adb shell screenrecord /sdcard/runCase.mp4");
		System.out.println("视频保存在：" + "/sdcard/runCase.mp4");
	}

}
