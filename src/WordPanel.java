import javax.swing.*;

/**
 * Created by CEsponda on 2/22/2017.
 */
public class WordPanel extends JPanel {
    private JRadioButton QwordButton,DwordButton,WordButton,ByteButton;
    WordPanel(){
        QwordButton    = new JRadioButton("Qword");
        DwordButton   = new JRadioButton("Dword", true);
        WordButton = new JRadioButton("Word");
        ByteButton = new JRadioButton("Byte");
        ButtonGroup wgroup = new ButtonGroup();

        wgroup.add(DwordButton);
        wgroup.add(QwordButton);
        wgroup.add(WordButton);
        wgroup.add(ByteButton);

        add(DwordButton);
        add(QwordButton);
        add(WordButton);
        add(ByteButton);
    }

}
