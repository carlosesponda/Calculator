import javax.swing.*;
import java.awt.*;

/**
 * Created by espon on 2/8/2017.
 */
public class CalcPanel extends JPanel {
    private JLabel num1Label, num2Label;
    private JTextField num1Field, num2Field;

    public CalcPanel(){
        num1Label = new JLabel("Number1");
        num1Field = new JTextField(10);

        num2Label = new JLabel("Number 2");
        num2Field = new JTextField(10);

        add(num1Label);
        add(num1Field);

        add(num2Label);
        add(num2Field);


    }

    public int getNum1Text(){
        return Integer.parseInt(num1Field.getText());
    }
    public int getNum2Text(){
        return Integer.parseInt(num2Field.getText());
    }
}
