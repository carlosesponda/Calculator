import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by espon on 2/8/2017.
 */
public class Calculator extends JFrame implements ActionListener {
    private CalcPanel panel;
    private  JPanel panel2;
    private JButton addButton;
    private JTextField resultField;

    public Calculator(){
        panel = new CalcPanel();
        add(panel,BorderLayout.CENTER);

        panel2 = new JPanel();
        addButton = new JButton("ADD");
        resultField = new JTextField(10);

        panel2.add(addButton);
        panel2.add(resultField);
        add(panel2,BorderLayout.SOUTH);
        addButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton){
            int result = panel.getNum1Text() +panel.getNum2Text();
            resultField.setText("" + result);
        }
    }
}
