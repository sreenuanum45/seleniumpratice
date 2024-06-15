package mypractice_utility.AdvanceSeleniumPratice.SeleniumListeners;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyListener implements WebDriverListener {
   {
       // Ensure MyListener implements WebDriverListener

       if (!(WebDriverListener.class.isAssignableFrom(MyListener.class))) {
           throw new IllegalStateException("MyListener must implement WebDriverListener");
       }

       if (!(WebDriverListener.class.isAssignableFrom(MyListener.class))) {
           throw new IllegalStateException("MyListener must implement WebDriverListener");
       }

   }


    // Implement other methods from the WebDriverListener interface as needed
}
