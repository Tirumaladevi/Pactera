package search;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testautomation {

public static WebDriver wd;
public static Properties p;

public static void Orproperties() throws IOException

{
	FileInputStream f=new FileInputStream("E:\\Testing Tools\\Project\\Pactera\\Pacteraor.txt");
	p=new Properties();
	p.load(f);
}

@BeforeClass
public static void openapp()
{
	wd=new FirefoxDriver();
	wd.get("http://www.pactera.com");
	wd.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}

@Test
public static void search() throws InterruptedException, IOException
{
	Orproperties();
	wd.findElement(By.xpath(p.getProperty("searchfor"))).sendKeys("test automation");
	wd.findElement(By.xpath(p.getProperty("searchsubmit"))).click();
	Thread.sleep(6000);
}
@AfterClass
public static void closeapp()
{
	wd.quit();
}
}
