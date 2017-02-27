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
    private JLabel decLabel,decField,hexLabel,hexField,octLabel,octField,binLabel,binField;// main text field for output and input

    public Calculator(){
        //Controls the locations of the Grid
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        //adds options to the top
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem minimizeAction = new JMenuItem("Hide");
        JMenuItem helpAction = new JMenuItem("Help");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        //adds text
        decLabel = new JLabel("Dec: ");
        decField = new JLabel("");
        decLabel.setPreferredSize(new Dimension(300, 30));
        hexLabel = new JLabel("Hex: ");
        hexField = new JLabel("");
        hexLabel.setPreferredSize(new Dimension(300, 30));
        binLabel = new JLabel("Bin: ");
        binField = new JLabel("");
        binLabel.setPreferredSize(new Dimension(300, 30));
        octLabel = new JLabel("Oct: ");
        octField = new JLabel("");
        octLabel.setPreferredSize(new Dimension(300, 30));
        //RadioButtons
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
        Squ = new JButton("Sqr()");
        Per = new JButton("%");
        Inv = new JButton("1/x");
        Equ = new JButton("=");

        //Button group for radio
        ButtonGroup wgroup = new ButtonGroup();
        wgroup.add(DwordButton);
        wgroup.add(QwordButton);
        wgroup.add(WordButton);
        wgroup.add(ByteButton);

        panel = new JPanel(new GridBagLayout());


        //Set locations and adds colors to the text fields
        c.gridy=0;
        decField.setOpaque(true);
        decField.setPreferredSize(new Dimension(180, 20));
        decField.setHorizontalAlignment(JLabel.RIGHT);
        decField.setBackground(new Color(210, 200, 200));
        JPanel rowPanel0 = new JPanel();
        rowPanel0.add(decLabel);
        rowPanel0.add(decField);
        panel.add(rowPanel0,c);


        c.gridy = 1;
        hexField.setOpaque(true);
        hexField.setPreferredSize(new Dimension(180, 20));
        hexField.setHorizontalAlignment(JLabel.RIGHT);
        hexField.setBackground(new Color(100, 147, 255));
        JPanel row = new JPanel();
        row.add(hexLabel);
        row.add(hexField);
        panel.add(row,c);

        c.gridy = 2;
        binField.setOpaque(true);
        binField.setPreferredSize(new Dimension(180, 20));
        binField.setHorizontalAlignment(JLabel.RIGHT);
        binField.setBackground(new Color(10, 200, 100));
        JPanel row1 = new JPanel();
        row1.add(binLabel);
        row1.add(binField);
        panel.add(row1,c);

        c.gridy = 3;
        octField.setOpaque(true);
        octField.setPreferredSize(new Dimension(180, 20));
        octField.setHorizontalAlignment(JLabel.RIGHT);
        octField.setBackground(new Color(255, 150, 0));
        JPanel row2 = new JPanel();
        row2.add(octLabel);
        row2.add(octField);
        panel.add(row2,c);

        c.gridy = 4;
        JPanel rowPanel1 = new JPanel();
        //rowPanel1.add(HexButton);
        rowPanel1.add(DwordButton);
        rowPanel1.add(A);
        rowPanel1.add(Quot);
        rowPanel1.add(Mod);
        panel.add(rowPanel1, c);

        c.gridy=5;
        JPanel rowPanel2 = new JPanel();
        //rowPanel2.add(DecButton);
        rowPanel2.add(QwordButton);
        rowPanel2.add(B);
        rowPanel2.add(BackSpace);
        rowPanel2.add(CE);
        rowPanel2.add(Clear);
        rowPanel2.add(Signs);
        panel.add(rowPanel2, c);

        c.gridy=6;
        JPanel rowPanel3 = new JPanel();
        //rowPanel3.add(OctButton);
        rowPanel3.add(WordButton);
        rowPanel3.add(C);
        rowPanel3.add(Sev);
        rowPanel3.add(Eig);
        rowPanel3.add(Nin);
        rowPanel3.add(Div);
        rowPanel3.add(Squ);
        panel.add(rowPanel3, c);

        c.gridy=7;
        JPanel rowPanel4 = new JPanel();
        //rowPanel4.add(BinButton);
        rowPanel4.add(ByteButton);
        D.setPreferredSize(new Dimension(45,25));
        rowPanel4.add(D);
        rowPanel4.add(Fou);
        rowPanel4.add(Fiv);
        rowPanel4.add(Six);
        rowPanel4.add(Mult);
        rowPanel4.add(Per);
        panel.add(rowPanel4, c);

        c.gridy=8;
        JPanel rowPanel5 = new JPanel();
        E.setPreferredSize(new Dimension(100,25));
        rowPanel5.add(E);
        rowPanel5.add(One);
        rowPanel5.add(Two);
        rowPanel5.add(Thr);
        rowPanel5.add(Min);
        rowPanel5.add(Inv);
        panel.add(rowPanel5, c);

        c.gridy=9;
        JPanel rowPanel6 = new JPanel();
        F.setPreferredSize(new Dimension(100,25));
        rowPanel6.add(F);
        Zer.setPreferredSize(new Dimension(90,25));
        rowPanel6.add(Zer);
        rowPanel6.add(Dot);
        rowPanel6.add(Plu);
        rowPanel6.add(Equ);
        panel.add(rowPanel6, c);
        Sev.addActionListener(this);
        Eig.addActionListener(this);
        Nin.addActionListener(this);
        Fou.addActionListener(this);
        Fiv.addActionListener(this);
        Six.addActionListener(this);
        Thr.addActionListener(this);
        Two.addActionListener(this);
        One.addActionListener(this);
        Zer.addActionListener(this);
        Dot.addActionListener(this);
        BackSpace.addActionListener(this);
        CE.addActionListener(this);
        Clear.addActionListener(this);
        Signs.addActionListener(this);

        Div.addActionListener(this);
        Mult.addActionListener(this);
        Min.addActionListener(this);
        Plu.addActionListener(this);
        Squ.addActionListener(this);
        Per.addActionListener(this);
        Inv.addActionListener(this);
        Equ.addActionListener(this);
        add(panel);


    }
    private void update(){
        if(!decField.getText().equals("")) {
            if (Double.parseDouble(decField.getText()) % 1 == 0) {
                hexField.setText(Integer.toHexString(Integer.parseInt(decField.getText())));
                binField.setText(Integer.toBinaryString(Integer.parseInt(decField.getText())));
                octField.setText(Integer.toOctalString(Integer.parseInt(decField.getText())));
            } else {
                hexField.setText(Double.toHexString(Double.parseDouble(decField.getText())));
                binField.setText("Can't Do it with decimals");
                octField.setText("Can't Do it with decimals");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Sev){
            decField.setText(decField.getText()+"7");
            update();
            }

        if (e.getSource()==Eig){
            decField.setText(decField.getText()+"8");
            update();
        }
        if (e.getSource()==Nin){
            decField.setText(decField.getText()+"9");
            update();
        }
        if (e.getSource()==Fou){
            decField.setText(decField.getText()+"4");
            update();
        }
        if (e.getSource()==Fiv){
            decField.setText(decField.getText()+"5");
            update();
        }
        if (e.getSource()==Six){
            decField.setText(decField.getText()+"6");
            update();
        }
        if (e.getSource()==Thr){
            decField.setText(decField.getText()+"3");
            update();
        }
        if (e.getSource()==Two){
            decField.setText(decField.getText()+"2");
            update();
        }
        if (e.getSource()==One){
            decField.setText(decField.getText()+"1");
            update();
        }
        if (e.getSource()==Zer){
            decField.setText(decField.getText()+"0");
            update();
        }
        if (e.getSource()==Dot){
            decField.setText(decField.getText()+".");
            update();
        }
        if (e.getSource()==BackSpace){
            if(!decField.getText().isEmpty())
            decField.setText(decField.getText().substring(0,decField.getText().length()-1));
            update();
        }
        if(e.getSource()==CE){
            decField.setText("");
            hexField.setText("");
            octField.setText("");
            binField.setText("");

        }
        if(e.getSource()==Clear){
            decField.setText("");
            hexField.setText("");
            octField.setText("");
            binField.setText("");
        }
        if(e.getSource()==Signs){
            if(!decField.getText().substring(0,1).equals("-"))
                decField.setText("-"+decField.getText());
            else
                decField.setText(decField.getText().substring(1,decField.getText().length()));
        }
        if(e.getSource()==Div){
            if(!decField.getText().substring(decField.getText().length()-1).equals("/"))
                decField.setText(decField.getText()+"/");
            else
                decField.setText(decField.getText().substring(0,decField.getText().length()-1));
        }
        if(e.getSource()==Mult){
            if(!decField.getText().substring(decField.getText().length()-1).equals("*"))
                decField.setText(decField.getText()+"*");
            else
                decField.setText(decField.getText().substring(0,decField.getText().length()-1));
        }
        if(e.getSource()==Min){
            if(!decField.getText().substring(decField.getText().length()-1).equals("-"))
                decField.setText(decField.getText()+"-");
            else
                decField.setText(decField.getText().substring(0,decField.getText().length()-1));
        }
        if(e.getSource()==Plu){
            if(!decField.getText().substring(decField.getText().length()-1).equals("+"))
                decField.setText(decField.getText()+"+");
            else
                decField.setText(decField.getText().substring(0,decField.getText().length()-1));
        }
        if(e.getSource()==Squ){
            if(!decField.getText().equals(""))
                decField.setText(String.valueOf(Math.sqrt(Double.parseDouble(decField.getText()))));
        }
        if(e.getSource()==Per){
            if(!decField.getText().substring(decField.getText().length()-1).equals("%"))
                decField.setText(decField.getText()+"%");
            else
                decField.setText(decField.getText().substring(0,decField.getText().length()-1));
        }
        if(e.getSource()==Squ){
            if(!decField.getText().equals(""))
                decField.setText(String.valueOf(Math.sqrt(Double.parseDouble(decField.getText()))));
        }
        if(e.getSource()==Inv){
            if(!decField.getText().equals(""))
                decField.setText(String.valueOf( 1/Double.parseDouble(decField.getText()) ) );
        }

    }
}
