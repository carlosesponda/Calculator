import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by espon on 2/8/2017.
 */
public class Calculator extends JFrame implements ActionListener {
    private CalcPanel panel;
    private  RadioPanel rpanel;
    private JButton addButton;
    private JTextField resultField;

    public Calculator(){
        panel = new CalcPanel();
        rpanel = new RadioPanel();
        add(panel,BorderLayout.NORTH);
        add(rpanel,BorderLayout.WEST);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
