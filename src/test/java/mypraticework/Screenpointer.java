package mypraticework;

import java.awt.*;

public class Screenpointer {
    public static void main(String[] args) throws InterruptedException {

        // Get the current mouse pointer coordinates
        for(;;)
        {
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();

            // Display the coordinates
            System.out.println("Mouse X: " + mouseLocation.getX()+ "Mouse Y: " + mouseLocation.getY());
            Thread.sleep(2000);
    }
}
}