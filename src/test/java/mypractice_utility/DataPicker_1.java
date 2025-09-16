package mypractice_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class DataPicker_1 {
    public void dateSelector(WebElement datePickerElement, RemoteWebDriver driver, int expectedYear, String expectedMonth, int expectedDay,String time) throws InterruptedException {
        // Scroll into view and click the date picker to open the calendar
        driver.executeScript("arguments[0].scrollIntoView(true);", datePickerElement);
        datePickerElement.click();
WebElement dateAndMonth=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
String[] parts =dateAndMonth.getText().split(" ");

        // Extract month and year
        String month = parts[0];
        String year = parts[1];
        // Navigate to the correct year
        while (true) {
            //String yearText = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']")).getText();
            int currentYear = Integer.parseInt(year);

            if (currentYear < expectedYear) {
                clickNext(driver);
            } else if (currentYear > expectedYear) {
                clickPrevious(driver);
            } else {
                break;
            }
        }

        // Navigate to the correct month
        while (true) {
           // String currentMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")).getText();

            if (month.equalsIgnoreCase(expectedMonth)) {
                break;
            } else {
                clickNext(driver);
            }
        }

        // Select the desired day
        try {
            WebElement dayElement = driver.findElement(By.xpath("(//div[@role='option'])[" + expectedDay + "]"));
            dayElement.click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Day " + expectedDay + " is not available in the calendar for the selected month and year.");
        }

     
    }

    /**
     * Clicks the 'Next' button in the date picker.
     */
    private void clickNext(RemoteWebDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//span[text()='Next Month']//parent::button")).click();
            Thread.sleep(500); // Adjusted for smoother transitions
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Next button is not available in the date picker.");
        }
    }

    /**
     * Clicks the 'Previous' button in the date picker.
     */
    private void clickPrevious(RemoteWebDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//span[text()='Previous Month']//parent::button")).click();
            Thread.sleep(500); // Adjusted for smoother transitions
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Previous button is not available in the date picker.");
        }
    }
}
