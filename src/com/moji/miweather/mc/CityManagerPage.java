package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class CityManagerPage extends BasePage {
	String[] cityNameList = { "������", "�����", "�Ϻ���", "������", "������", "������", "������", "��������" };

	public void addCity() throws InterruptedException {

		for (int i = 0; i < cityNameList.length; i++) {
			// ������й����б�
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElementById("com.moji.mjweather:id/area_name_tv").click();
			Thread.sleep(5000);

			List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");// ��ȡImageView������Ԫ��
			WebElement targetEle = list.get(2);// ��ȡ�б��еڶ���ImageViewԪ��,������ӳ���
			targetEle.click();

			WebElement el = driver.findElement(By.name(cityNameList[i].toString()));
			el.click();

			if (i == 7) {
				// ��������һ�����л���뵽������ҳ���ٵ��һ����ҳ��������������й���ҳ��
				driver.findElementById("com.moji.mjweather:id/area_name_tv").click();
				snapshot((TakesScreenshot) driver, "���й����б�.png");
			}
			deleteCity();
		}
		// ��ӵ�ʮ������
		// ��ȡImageView������Ԫ��
		List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");
		WebElement targetEle = list.get(2);// ��ȡ�б��еڶ���ImageViewԪ��,������ӳ���
		targetEle.click();
		snapshot((TakesScreenshot) driver, "��ӵ�ʮ������.png");
	}

	/**
	 * ɾ������ 1.����ҳ������й����б�ɾ������9������ 2.ɾ�����г��У�ҳ��ͣ���ڡ��������С�ҳ�棬��ͨ����ӳ��н���������ҳ
	 * 
	 * @author MC
	 * @throws InterruptedException
	 */

	public void deleteCity() throws InterruptedException {
		driver.findElementById("com.moji.mjweather:id/area_name_tv").click();// ģ�����
		// ���й����б�༭
		List<WebElement> list0 = driver.findElementsByClassName("android.widget.ImageView");// ��ȡImageView������Ԫ��

		// snapshot((TakesScreenshot) driver, "׼��ɾ��.png");
		// ѭ��ɾ������
		for (int i = 0; i < cityNameList.length + 1; i++) {
			WebElement targetEle0 = list0.get(1);// ��ȡ�б��еڶ���ImageViewԪ��(��icon),׼��ɾ������
			targetEle0.click();
			driver.findElementById("com.moji.mjweather:id/item_city_name_handle").click();
			WebElement e1 = driver.findElementByName("ɾ��");
			e1.click();

			List<WebElement> list1 = driver.findElementsByClassName("android.widget.ImageView");// ��ȡImageView������Ԫ��
			WebElement targetEle1 = list1.get(0);// ��ȡ�б��е�һ��ImageViewԪ��,׼��ɾ������
			targetEle1.click();
			Thread.sleep(1000);
			if (i == 8) {
				snapshot((TakesScreenshot) driver, "ɾ�����к�.png");
			}
		}
	}
}
