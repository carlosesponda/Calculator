import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by espon on 2/8/2017.
 */
public class CalculatorTesting {

    public static void main (String [] args){


        Calculator window = new Calculator();
        window.setSize(700,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("My First Calulator");

    }
}
