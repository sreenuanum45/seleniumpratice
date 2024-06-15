package mypractice_utility.AdvanceSeleniumPratice.RobotclassPratice;

import java.awt.*;

public class Test1 {
    public static void main(String[] args) {
        while (true) {
            // Get the current mouse position
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            java.awt.Point point = pointerInfo.getLocation();

            // Print the mouse position
            System.out.println("Mouse Position: X = " + point.getX() + ", Y = " + point.getY());

            // Add a delay to avoid printing too quickly
            try {
                Thread.sleep(1000); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
}

    }
}
