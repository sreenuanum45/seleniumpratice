package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownOperations{

    WebDriver driver;

    public SelectDropdownOperations(WebDriver driver) {
        this.driver = driver;
    }

    public void singleSelect(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public void multiSelect(By locator, String[] values) {
        Select dropdown = new Select(driver.findElement(locator));
        for (String value : values) {
            dropdown.selectByVisibleText(value);
        }
    }

    public void selectByValue(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    public void selectByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectAll(By locator) {
        Select dropdown = new Select(driver.findElement(locator));
        for (WebElement option : dropdown.getOptions()) {
            option.click();
        }
    }

    public void deselectAll(By locator) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectAll();
    }

    public void deselectByValue(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByValue(value);
    }

    public void deselectByIndex(By locator, int index) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByIndex(index);
    }

    public void deselectByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByVisibleText(visibleText);
    }

    // Combination Methods
    public void deselectAllAndSelectAll(By locator) {
        deselectAll(locator);
        selectAll(locator);
    }

    public void selectAllAndDeselectAll(By locator) {
        selectAll(locator);
        deselectAll(locator);
    }

    public void selectByValueAndDeselectAll(By locator, String value) {
        selectByValue(locator, value);
        deselectAll(locator);
    }

    public void selectByIndexAndDeselectAll(By locator, int index) {
        selectByIndex(locator, index);
        deselectAll(locator);
    }

    public void selectByVisibleTextAndDeselectAll(By locator, String visibleText) {
        selectByVisibleText(locator, visibleText);
        deselectAll(locator);
    }

    public void selectAllAndDeselectByValue(By locator, String value) {
        selectAll(locator);
        deselectByValue(locator, value);
    }

    public void selectAllAndDeselectByIndex(By locator, int index) {
        selectAll(locator);
        deselectByIndex(locator, index);
    }

    public void selectAllAndDeselectByVisibleText(By locator, String visibleText) {
        selectAll(locator);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByValueAndDeselectByIndex(By locator, String value, int index) {
        selectByValue(locator, value);
        deselectByIndex(locator, index);
    }

    public void selectByValueAndDeselectByVisibleText(By locator, String value, String visibleText) {
        selectByValue(locator, value);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByIndexAndDeselectByValue(By locator, int index, String value) {
        selectByIndex(locator, index);
        deselectByValue(locator, value);
    }

    public void selectByIndexAndDeselectByVisibleText(By locator, int index, String visibleText) {
        selectByIndex(locator, index);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByVisibleTextAndDeselectByValue(By locator, String visibleText, String value) {
        selectByVisibleText(locator, visibleText);
        deselectByValue(locator, value);
    }

    public void selectByVisibleTextAndDeselectByIndex(By locator, String visibleText, int index) {
        selectByVisibleText(locator, visibleText);
        deselectByIndex(locator, index);
    }

    public void selectByVisibleTextAndDeselectByVisibleText(By locator, String visibleText1, String visibleText2) {
        selectByVisibleText(locator, visibleText1);
        deselectByVisibleText(locator, visibleText2);
    }

    public void selectByValueAndDeselectByValueAndDeselectByIndex(By locator, String value1, String value2, int index) {
        selectByValue(locator, value1);
        deselectByValue(locator, value2);
        deselectByIndex(locator, index);
    }

    public void selectByValueAndDeselectByValueAndDeselectByVisibleText(By locator, String value1, String value2, String visibleText) {
        selectByValue(locator, value1);
        deselectByValue(locator, value2);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByIndexAndDeselectByIndexAndDeselectByVisibleText(By locator, int index1, int index2, String visibleText) {
        selectByIndex(locator, index1);
        deselectByIndex(locator, index2);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByVisibleTextAndDeselectByIndexAndDeselectByVisibleText(By locator, String visibleText1, int index, String visibleText2) {
        selectByVisibleText(locator, visibleText1);
        deselectByIndex(locator, index);
        deselectByVisibleText(locator, visibleText2);
    }

    public void selectByValueAndDeselectByIndexAndDeselectByVisibleText(By locator, String value, int index, String visibleText) {
        selectByValue(locator, value);
        deselectByIndex(locator, index);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByIndexAndDeselectByValueAndDeselectByVisibleText(By locator, int index, String value, String visibleText) {
        selectByIndex(locator, index);
        deselectByValue(locator, value);
        deselectByVisibleText(locator, visibleText);
    }

    public void selectByVisibleTextAndDeselectByValueAndDeselectByVisibleText(By locator, String visibleText1, String value, String visibleText2) {
        selectByVisibleText(locator, visibleText1);
        deselectByValue(locator, value);
        deselectByVisibleText(locator, visibleText2);
    }
}
