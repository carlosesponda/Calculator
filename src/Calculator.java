import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Stack;

/**
 * Created by espon on 2/8/2017.
 */
public class Calculator extends JFrame implements ActionListener {
    private JPanel panel;
    private JRadioButton QwordButton,DwordButton,WordButton,ByteButton;
    private JButton Quot, Mod, A, B, C, D, E, F,BackSpace, CE,Clear,Sev, Eig, Nin,Fou, Fiv, Six, One, Two, Thr, Zer, Dot, Signs, Div, Mult, Min,Plu, Squ, Per,Inv, Equ;
    private JLabel decLabel,decField,hexLabel,hexField,octLabel,octField,binLabel,binField, editLabel,editField, eLabel, eField;// main text field for output and input
    private boolean operator =false;
    private boolean isDouble = false;
    private JMenuItem helpAction, minimizeAction, hexcopy,dexcopy,bincopy,octcopy;
    private Stack<Integer> Index;
    private boolean zero=false;
    private boolean solve = false;
    public Calculator(){
        //Controls the locations of the Grid
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
       // JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        Index = new Stack<Integer>();
        //pop = new JPopupMenu("Hello! This is Carlos Esponda's first Calculator, You can't type but you can use the buttons! try it out");
        //adds options to the top
        //JMenuItem exitAction = new JMenuItem("Exit");
        minimizeAction = new JMenuItem("Hide");
        helpAction = new JMenuItem("Hello! This is Carlos Esponda's first Calculator, You can't type but you can use the buttons! try it out! Also To negate a number first type the number then press the +/- button");
        hexcopy = new JMenuItem("Copy Hex");
        dexcopy = new JMenuItem("Copy Dec");
        bincopy = new JMenuItem("Copy Bin");
        octcopy = new JMenuItem("Copy Oct");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(helpAction);
        viewMenu.add(minimizeAction);
        editMenu.add(hexcopy);
        editMenu.add(dexcopy);
        editMenu.add(bincopy);
        editMenu.add(octcopy);
        minimizeAction.addActionListener(this);
        hexcopy.addActionListener(this);
        dexcopy.addActionListener(this);
        bincopy.addActionListener(this);
        octcopy.addActionListener(this);

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
        editLabel = new JLabel("Edit: ");
        editField = new JLabel("");
        editLabel.setPreferredSize(new Dimension(300, 30));
        eLabel = new JLabel("Equation: ");
        eField = new JLabel("");
        eLabel.setPreferredSize(new Dimension(300, 30));
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

        c.gridy=0;
        eField.setOpaque(true);
        eField.setPreferredSize(new Dimension(180, 20));
        eField.setHorizontalAlignment(JLabel.RIGHT);
        eField.setBackground(new Color(250, 0, 250));
        JPanel rowe = new JPanel();
        rowe.add(eLabel);
        rowe.add(eField);
        panel.add(rowe,c);

        c.gridy=1;
        editField.setOpaque(true);
        editField.setPreferredSize(new Dimension(180, 20));
        editField.setHorizontalAlignment(JLabel.RIGHT);
        editField.setBackground(new Color(250, 10, 90));
        JPanel row0 = new JPanel();
        row0.add(editLabel);
        row0.add(editField);
        panel.add(row0,c);


        //Set locations and adds colors to the text fields
        c.gridy=2;
        decField.setOpaque(true);
        decField.setPreferredSize(new Dimension(180, 20));
        decField.setHorizontalAlignment(JLabel.RIGHT);
        decField.setBackground(new Color(210, 200, 200));
        JPanel rowPanel0 = new JPanel();
        rowPanel0.add(decLabel);
        rowPanel0.add(decField);
        panel.add(rowPanel0,c);


        c.gridy = 3;
        hexField.setOpaque(true);
        hexField.setPreferredSize(new Dimension(180, 20));
        hexField.setHorizontalAlignment(JLabel.RIGHT);
        hexField.setBackground(new Color(100, 147, 255));
        JPanel row = new JPanel();
        row.add(hexLabel);
        row.add(hexField);
        panel.add(row,c);

        c.gridy = 4;
        binField.setOpaque(true);
        binField.setPreferredSize(new Dimension(180, 20));
        binField.setHorizontalAlignment(JLabel.RIGHT);
        binField.setBackground(new Color(10, 200, 100));
        JPanel row1 = new JPanel();
        row1.add(binLabel);
        row1.add(binField);
        panel.add(row1,c);

        c.gridy = 5;
        octField.setOpaque(true);
        octField.setPreferredSize(new Dimension(180, 20));
        octField.setHorizontalAlignment(JLabel.RIGHT);
        octField.setBackground(new Color(255, 150, 0));
        JPanel row2 = new JPanel();
        row2.add(octLabel);
        row2.add(octField);
        panel.add(row2,c);

        c.gridy = 6;
        JPanel rowPanel1 = new JPanel();
        //rowPanel1.add(HexButton);
        rowPanel1.add(DwordButton);
        rowPanel1.add(A);
        rowPanel1.add(Quot);
        rowPanel1.add(Mod);
        panel.add(rowPanel1, c);

        c.gridy=7;
        JPanel rowPanel2 = new JPanel();
        //rowPanel2.add(DecButton);
        rowPanel2.add(QwordButton);
        rowPanel2.add(B);
        rowPanel2.add(BackSpace);
        rowPanel2.add(CE);
        rowPanel2.add(Clear);
        rowPanel2.add(Signs);
        panel.add(rowPanel2, c);

        c.gridy=8;
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

        c.gridy=9;
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

        c.gridy=10;
        JPanel rowPanel5 = new JPanel();
        E.setPreferredSize(new Dimension(100,25));
        rowPanel5.add(E);
        rowPanel5.add(One);
        rowPanel5.add(Two);
        rowPanel5.add(Thr);
        rowPanel5.add(Min);
        rowPanel5.add(Inv);
        panel.add(rowPanel5, c);

        c.gridy=11;
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
    private void Back(){
        if(!editField.getText().isEmpty())
            editField.setText(editField.getText().substring(0, editField.getText().length() - 1));
    }
    private void addOperator(String operator){
        if(eField.getText().isEmpty())
            eField.setText(editField.getText()+" "+operator+" ");
        else
            eField.setText(eField.getText()+editField.getText()+" "+operator+" ");

        editField.setText("");

    }
    private void addNumber(String n){editField.setText(editField.getText()+n); operator=false;}
    private void update(){
        if(!decField.getText().equals("")) {
            if (Double.parseDouble(decField.getText()) % 1 == 0 && !isDouble) {
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
    private void equation(boolean b){
        if(b){
            eField.setText("");
            this.solve=false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Sev){
            addNumber("7");
            equation(solve);
            }
        if (e.getSource()==Eig){
            addNumber("8");
            equation(solve);
        }
        if (e.getSource()==Nin){
            addNumber("9");
            equation(solve);
        }
        if (e.getSource()==Fou){
            addNumber("4");
            equation(solve);
        }
        if (e.getSource()==Fiv){
            addNumber("5");
            equation(solve);
        }
        if (e.getSource()==Six){
            addNumber("6");
            equation(solve);
        }
        if (e.getSource()==Thr){
            addNumber("3");
            equation(solve);
        }
        if (e.getSource()==Two){
            addNumber("2");
            equation(solve);
        }
        if (e.getSource()==One){
            addNumber("1");
            equation(solve);
        }
        if (e.getSource()==Zer){
            addNumber("0");
            equation(solve);
        }
        if (e.getSource()==Dot){
            addNumber(".");
            isDouble=true;
        }
        if (e.getSource()==BackSpace){
            if(!editField.getText().isEmpty())
                editField.setText(editField.getText().substring(0,editField.getText().length()-1));
        }
        if( e.getSource()==Clear){
            editField.setText("");
        }
        if( e.getSource()==CE){
            eField.setText("");
        }

        if(e.getSource()==Signs){
            if(!editField.getText().substring(0,1).equals("-")) {
                editField.setText("-" + editField.getText());
            }
            else {
                editField.setText(editField.getText().substring(1, editField.getText().length()));
            }
        }
        if(e.getSource()==Div){
            if(!editField.getText().isEmpty() && !editField.getText().substring(editField.getText().length()-1).equals("/")&&!operator) {
                addOperator("/");
                operator=true;
            }
            else {
                Back();
                operator=false;
            }

        }
        if(e.getSource()==Mult){
            if(!editField.getText().isEmpty() && !editField.getText().substring(editField.getText().length()-1).equals("*")&&!operator) {
                addOperator("*");
                operator=true;
            }
            else {
                Back();
                operator=false;
            }

        }
        if(e.getSource()==Min){
            if(!editField.getText().isEmpty() && !editField.getText().substring(editField.getText().length()-1).equals("-")&& !operator ) {
                addOperator("-");
                operator=true;
            }
            else {
                Back();
                operator=false;
            }
        }
        if(e.getSource()==Plu){
            if(!editField.getText().isEmpty() && !editField.getText().substring(editField.getText().length()-1).equals("+") &&!operator) {
                addOperator("+");
                operator=true;
            }
            else {
                Back();
                operator=false;

            }
        }
        if(e.getSource()==Squ){
            if(!editField.getText().equals("")) {
                isDouble=true;
                decField.setText(String.valueOf(Math.sqrt(Double.parseDouble(editField.getText()))));
                update();
                editField.setText("");
                isDouble=false;
            }
        }
        if(e.getSource()==Per){
            if( !editField.getText().isEmpty() && !editField.getText().substring(editField.getText().length()-1).equals("%")&&!operator ) {
                addOperator("%");
                operator=true;

            }
            else {
                Back();
                operator=false;

            }
        }
        if(e.getSource()==Inv){
            if(!editField.getText().equals("")) {
                isDouble=true;
                decField.setText(String.valueOf(1 / Double.parseDouble(editField.getText())));
                update();
                editField.setText("");
                isDouble=false;
            }
        }
        if(e.getSource()==Equ){
            if(!editField.getText().equals(""))
            {
                eField.setText(eField.getText()+ editField.getText());
                decField.setText(String.valueOf(computeInfixExpr(eField.getText())));
                update();
                if(zero){
                    editField.setText("");
                    decField.setText("inf");
                    hexField.setText("inf");
                    octField.setText("inf");
                    binField.setText("inf");
                    eField.setText("");
                    zero = false;
                }
                else {
                    editField.setText("");
                    eField.setText(decField.getText());
                    solve = true;
                }
            }
        }
        if(e.getSource()==minimizeAction){
            setState(Frame.ICONIFIED);
        }
        if(e.getSource()==hexcopy){
           copy(hexField);
        }
        if(e.getSource()==dexcopy){
           copy(decField);
        }
        if(e.getSource()==octcopy){
            copy(octField);
        }
        if(e.getSource()==bincopy){
            copy(binField);
        }

    }
    public int computeInfixExpr(String input) {
        String[] expr = input.split(" ");
        int i = 0;
        int operLeft = Integer.valueOf(expr[i++]);
        while (i < expr.length) {
            String operator = expr[i++];
            int operRight = Integer.valueOf(expr[i++]);
            switch (operator) {
                case "*":
                    operLeft = operLeft * operRight;
                    break;
                case "/":
                    try {
                        operLeft = operLeft / operRight;
                    }
                    catch (Exception e){
                        zero = true;

                    }
                    break;
                case "%":
                    operLeft = operLeft % operRight;
                    break;
                case "+":
                case "-":
                    while (i < expr.length) {
                        String operator2 = expr[i++];
                        if (operator2.equals("+") || operator2.equals("-")) {
                            i--;
                            break;
                        }
                        if (operator2.equals("*")) {
                            operRight = operRight * Integer.valueOf(expr[i++]);
                        }
                        if (operator2.equals("/")) {
                            try {
                                if (Integer.valueOf(expr[i++]) != 0)
                                    operRight = operRight / Integer.valueOf(expr[i++]);
                            }
                            catch (Exception e){
                                editField.setText("Can't Divide by Zero");
                            }
                        }
                        if (operator2.equals("%")) {
                            if(Integer.valueOf(expr[i++])!=0)
                                operRight = operRight % Integer.valueOf(expr[i++]);
                        }
                    }
                    if(operator.equals("+"))
                        operLeft = operLeft + operRight;
                    else if(operator.equals("-"))
                        operLeft = operLeft - operRight;
                    break;
            }
        }
        return operLeft;
    }
    public void copy(JLabel field){
        String myString = field.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }
}
