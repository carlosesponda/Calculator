import com.sun.org.apache.xpath.internal.operations.Quo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by espon on 2/8/2017.
 */
public class CalcPanel extends JPanel {

    private JTextField main;// main text field for output and input
    private JButton Quot;




    public CalcPanel(){

        main = new JTextField(40);
        add(main);
        //... Create the buttons.
        JRadioButton HexButton    = new JRadioButton("Hex");
        JRadioButton DecButton   = new JRadioButton("Dec", true);
        JRadioButton OctButton = new JRadioButton("Oct");
        JRadioButton BinButton = new JRadioButton("Bin");

        JRadioButton QwordButton    = new JRadioButton("Qword");
        JRadioButton DwordButton   = new JRadioButton("Dword", true);
        JRadioButton WordButton = new JRadioButton("Word");
        JRadioButton ByteButton = new JRadioButton("Byte");

        Quot = new JButton("Quot");
        Quot.setPreferredSize(new Dimension(10,10));
        //... Create a button group and add the buttons.
        ButtonGroup bgroup = new ButtonGroup();

        ButtonGroup wgroup = new ButtonGroup();
        bgroup.add(DecButton);
        bgroup.add(HexButton);
        bgroup.add(OctButton);
        bgroup.add(BinButton);

        wgroup.add(DwordButton);
        wgroup.add(QwordButton);
        wgroup.add(WordButton);
        wgroup.add(ByteButton);

        //... Arrange buttons vertically in a panel
        setLayout(new GridLayout(9, 100,5,5));
        add(DecButton);
        add(HexButton);
        add(OctButton);
        add(BinButton);

        add(DwordButton);
        add(QwordButton);
        add(WordButton);
        add(ByteButton);

        //add(Quot);

        //... Add a titled border to the button panel.


        //... Set window attributes.






    }

}
