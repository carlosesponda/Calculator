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
    private JPanel panel;
    private JRadioButton HexButton,DecButton,OctButton,BinButton,QwordButton,DwordButton,WordButton,ByteButton;
    private JButton Quot, Mod, A, B, C, D, E, F,BackSpace, CE,Clear,Sev, Eig, Nin,Fou, Fiv, Six, One, Two, Thr, Zer, Dot, Signs, Div, Mult, Min,Plu, Squ, Per,Inv, Equ;
    private JTextField main;// main text field for output and input

    public Calculator(){
        //Controls the locations of the Grid
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        //adds text
        main = new JTextField(40);
        main.setPreferredSize(new Dimension(300, 30));
        //Radio Buttons
        HexButton    = new JRadioButton("Hex");
        DecButton   = new JRadioButton("Dec", true);
        OctButton = new JRadioButton("Oct");
        BinButton = new JRadioButton("Bin");
        QwordButton    = new JRadioButton("Qword");
        DwordButton   = new JRadioButton("Dword", true);
        WordButton = new JRadioButton("Word");
        ByteButton = new JRadioButton("Byte");
        //Buttons
        Quot = new JButton("Quot");
        Mod = new JButton("Mod");
        BackSpace = new JButton("Back");
        Clear = new JButton("Clear");
        CE= new JButton("CE");
        A = new JButton("A");
        B = new JButton("B");
        C = new JButton("C");
        D = new JButton("D");
        E = new JButton("E");
        F = new JButton("F");
        //NumberPad in order of from top to bottom reading left to right
        Sev = new JButton("7");
        Eig = new JButton("8");
        Nin = new JButton("9");
        Fou = new JButton("4");
        Fiv = new JButton("5");
        Six = new JButton("6");
        One = new JButton("1");
        Two = new JButton("2");
        Thr = new JButton("3");
        Zer = new JButton("0");
        Dot = new JButton(".");
        //Operator Signs
        Signs = new JButton("+/-");
        Div = new JButton("/");
        Mult = new JButton("*");
        Min = new JButton("-");
        Plu = new JButton("+");


        //... Create a button group and add the buttons.
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(DecButton);
        bgroup.add(HexButton);
        bgroup.add(OctButton);
        bgroup.add(BinButton);

        ButtonGroup wgroup = new ButtonGroup();
        wgroup.add(DwordButton);
        wgroup.add(QwordButton);
        wgroup.add(WordButton);
        wgroup.add(ByteButton);

        panel = new JPanel(new GridBagLayout());


        //Set locations
        c.gridy=0;
        panel.add(main,c);

        c.gridy = 1;
        JPanel rowPanel1 = new JPanel();
        rowPanel1.add(HexButton);
        rowPanel1.add(A);
        rowPanel1.add(Quot);
        rowPanel1.add(Mod);
        panel.add(rowPanel1, c);

        c.gridy=2;
        JPanel rowPanel2 = new JPanel();
        rowPanel2.add(DecButton);
        rowPanel2.add(B);
        rowPanel2.add(BackSpace);
        rowPanel2.add(CE);
        rowPanel2.add(Clear);
        rowPanel2.add(Signs);
        panel.add(rowPanel2, c);

        c.gridy=3;
        JPanel rowPanel3 = new JPanel();
        rowPanel3.add(OctButton);
        rowPanel3.add(C);
        rowPanel3.add(Sev);
        rowPanel3.add(Eig);
        rowPanel3.add(Nin);
        panel.add(rowPanel3, c);

        c.gridy=4;
        JPanel rowPanel4 = new JPanel();
        rowPanel4.add(BinButton);
        rowPanel4.add(D);
        rowPanel4.add(Fou);
        rowPanel4.add(Fiv);
        rowPanel4.add(Six);
        panel.add(rowPanel4, c);

        c.gridy=5;
        JPanel rowPanel5 = new JPanel();
        rowPanel5.add(DwordButton);
        rowPanel5.add(E);
        rowPanel5.add(One);
        rowPanel5.add(Two);
        rowPanel5.add(Thr);
        panel.add(rowPanel5, c);

        c.gridy=6;
        JPanel rowPanel6 = new JPanel();
        rowPanel6.add(QwordButton);
        rowPanel6.add(F);
        rowPanel6.add(Zer);
        rowPanel6.add(Dot);
        panel.add(rowPanel6, c);

        add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
