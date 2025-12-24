package ProjectAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Project {
	public static void main(String[] args) {
//driver declare
      WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 //opening web
     driver.get("https://blazedemo.com/");
 //select 
     WebElement select = driver.findElement(By.xpath("//select[@name='fromPort']"));
         Select val= new Select(select);
         val.selectByVisibleText("Paris");
   //select 
    
         WebElement se = driver.findElement(By.xpath("//select[@name='toPort']"));
         Select second= new Select(se);
         second.selectByVisibleText("Rome");
 //click on book
driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

 //getinng row size
List<WebElement> row = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
  System.out.println(row.size());
//geting price and storing val
  int minimum=Integer.MAX_VALUE;
  int index=-1;
  int price;
  String rate;
 //search amd store
  for(int i=1;i<row.size();i++)
  {
	  int trs=i;
	  rate=
	driver.findElement(By.xpath("//table[@class='table']//tr["+trs+"]//td[6]")).getText();
	  rate=rate.replace("$","");
	   price= (int) Double.parseDouble(rate);
	  if(price<minimum)
	  {
		  minimum=price;
		  index=i;
	  }
  }
   driver.findElement(By.xpath("//tbody/tr["+index+"]/td[1]/input[1]")).click();
  
      driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Ashwini kumar");
      driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Garhwa");
      driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Garhwa");
      driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Jharkhand");
      driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("822114");
      
      WebElement mo = driver.findElement(By.xpath("//select[@id='cardType']"));
      Select hu = new Select(mo);
      hu.selectByContainsVisibleText("Visa");
      driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Ashwini kumar");
      driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
      driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
      System.out.println("Booking details are as follow");
String nn= driver.findElement(By.xpath("//pre[contains(text(),'PendingCapture')]")).getText();
System.out.println(nn);


	}
	}

