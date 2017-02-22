import javax.swing.*;
import java.awt.*;

/**
 * Created by CEsponda on 2/22/2017.
 */
public class RadioPanel extends JPanel{

    private JRadioButton HexButton,DecButton,OctButton,BinButton;
    RadioPanel(){
        //... Create the buttons.
        HexButton    = new JRadioButton("Hex");
        DecButton   = new JRadioButton("Dec", true);
        OctButton = new JRadioButton("Oct");
        BinButton = new JRadioButton("Bin");




        //... Create a button group and add the buttons.
        ButtonGroup bgroup = new ButtonGroup();


        bgroup.add(DecButton);
        bgroup.add(HexButton);
        bgroup.add(OctButton);
        bgroup.add(BinButton);



        //... Arrange buttons vertically in a panel
        setLayout(new GridLayout(5, 5));
        add(DecButton);
        add(HexButton);
        add(OctButton);
        add(BinButton);





        //... Add a titled border to the button panel.
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));


        //... Set window attributes.

    }
}
