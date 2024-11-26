package mypractice_utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSSProperties {
    public String getallCSSProperties(WebElement e, RemoteWebDriver driver) {
        return (String) driver.executeScript(
                "var s = ''; " +
                        "var o = window.getComputedStyle(arguments[0]); " +
                        "for (var i = 0; i < o.length; i++) { " +
                        "  s = s + o[i] + ':' + o.getPropertyValue(o[i]) + ','; " +
                        "} " +
                        "return s;", e);
    }
    public int getCSSPropertiesCount(WebElement e, RemoteWebDriver driver) {
        return Integer.parseInt((String) driver.executeScript(
                "var s = ''; " +
                        "var o = window.getComputedStyle(arguments[0]); " +
                        "for (var i = 0; i < o.length; i++) { " +
                        "  s = s + o[i] + ':' + o.getPropertyValue(o[i]) + ','; " +
                        "} " +
                        "return o.length;", e));
    }
    public List<String> getCSSPropertiesNames(WebElement e, RemoteWebDriver driver) {
        return (List<String>) driver.executeScript(
                "var s = ''; " +
                        "var o = window.getComputedStyle(arguments[0]); " +
                        "for (var i = 0; i < o.length; i++) { " +
                        "  s = s + o[i] + ':' + o.getPropertyValue(o[i]) + ','; " +
                        "} " +
                        "return o;", e);
    }
    public Map<String, Object> getCSSPropertiesValues(WebElement e, RemoteWebDriver driver) {
        List<String> cssProperties = (List<String>) driver.executeScript(
                    "var properties = []; " +
                            "var o = window.getComputedStyle(arguments[0]); " +
                            "for (var i = 0; i < o.length; i++) { " +
                            "  properties.push(o[i] + ':' + o.getPropertyValue(o[i])); " +
                            "} " +
                            "return properties;", e);
        // Map to store CSS properties and their values
            Map<String, Object> cssMap = new HashMap<>();
            // Retrieve and store CSS properties in the map
            for (String property : cssProperties) {
                String[] splitProperty = property.split(":", 2);
                if (splitProperty.length == 2) {
                    cssMap.put(splitProperty[0], splitProperty[1]);
                }
            }
            return cssMap;
        }


    }

