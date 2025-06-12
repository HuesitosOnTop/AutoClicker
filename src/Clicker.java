import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker {
    private Robot robot;

    private double random_num;

    private int minumum_num = 0;
    private char chosen_char;

    private String[] ansi_colors = {
            "\u001B[30m", // Black                 0
            "\u001B[31m", // Red                   1 
            "\u001B[32m", // Green                 2
            "\u001B[33m", // Yellow                3
            "\u001B[34m", // Blue                  4
            "\u001B[35m", // Magenta               5
            "\u001B[36m", // Cyan                  6
            "\u001B[37m", // White                 7
            "\u001B[90m", // Bright Black (Gray)   8
            "\u001B[91m", // Bright Red            9
            "\u001B[92m", // Bright Green         10
            "\u001B[93m", // Bright Yellow        11
            "\u001B[94m", // Bright Blue          12
            "\u001B[95m", // Bright Magenta       13
            "\u001B[96m", // Bright Cyan          14
            "\u001B[97m", // Bright White         15
            "\u001B[0m"   // Reset                16
    };

    // Constructors
    public Clicker(int m) {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }

        minumum_num = m;

    }

    public Clicker(int m, char c) {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }

        minumum_num = m;
        chosen_char = c;
    }

    public Clicker(char c) {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        chosen_char = c;
    }

    public Clicker() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    This function is used for formatting the print of everything the clicker has

    NOTE: Colors appear differently on different OS's and im currently looking for a fix
    */

    public void fPrint(int print_choice, String message) { // Formated Print
        String pre_print = "";
        String[] choice_array = {
            ansi_colors[12] + "CLICKER",
            ansi_colors[1]  + "DEBUG",
            ansi_colors[6]  + "RANDOM NUMBER",
            ansi_colors[2]  + "COUNTER"
        };

        /*
         * 0 is Clicker print
         * 1 is Debug print
         * 2 is Random Number print
         * 3 is Counter print
         */

        for (int i = 0; i < choice_array.length; i++) {
            if (i == print_choice) {
                pre_print = ansi_colors[16] + ansi_colors[15] + "[$" + choice_array[i] + ansi_colors[15] + "]" + ansi_colors[10] + "!:" + ansi_colors[3] + "~ " + ansi_colors[16] + message + "\n";
            }
        }

        System.out.print(pre_print);
    }

    /*
    The following section is used for accsessing certain variables and information
    */

    public double GetRandomNumber() {
        return random_num;
    }

    public Point GetCurrentPosition() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    /*
    The following section is used for pieces of code that change values 
    or do things like Mouse click, scroll, and move
    */

    // Get a random number with a minimum of 15 seconds and rounds the number
    public void GenerateRandomNumber() { 
        random_num = Math.round((Math.random() * 5) + minumum_num); 
    }

    // Mouse Click
    public void MousePress() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); 
    }

    // Mouse Scroll
    public void MouseScroll(int ScrollAmt) {
        robot.mouseWheel(minumum_num); 
    }

    // Mouse Move
    public void MouseMove(int x, int y) {
        robot.mouseMove(x, y); 
    }

    /*
     The following section is used for more simplified ways to use the code
     and is pretty straight forward and can make a clicker in only 1-5 lines of code
    */

    // Automation Helpers

    // Timer before the clicker starts
    public void ClickerTimer(int start_value) {
        for (int i = start_value; i > 0; i--) {
            fPrint(0, "Clicker starting in: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fPrint(0, "Clicker Started");
    }

    // Wait inbetween clicks
    public void WaitTimer(int wait_time) {
        fPrint(0, "Waiting " + wait_time + " seconds before next click");
        try {
            Thread.sleep(1000 * wait_time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    The following section is only one function that does everything an auto clicker should
    it does not work right now and is not in development yet.
    

    public void AutoClick(int stop_at) {

    }

    */
}