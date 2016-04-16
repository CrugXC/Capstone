import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;

/**
 * Write a description of class PlayerStatsPanel here.
 * 
 * @author Jay Rixie
 * @version 4/15/16
 */
public class PlayerStatsPanel extends JPanel
{
    /** JLabel strength         displays strength number
       JLabel dexterity         displays dexterity number
       JLabel constitution      displays strength constitution
       JLabel intelligence      displays strength intelligence
       JLabel wisdom            displays wisdom number
       JLabel charisma          displays charisma number*/
       
    private JLabel strength;
    private JLabel dexterity;
    private JLabel constitution;
    private JLabel intelligence;
    private JLabel wisdom;
    private JLabel charisma;
    
    private GridLayout statLayout;
    /**
     * Default constructor for objects of class PlayerStatsPanel
     */
    public PlayerStatsPanel(InventoryPanel inv)
    {
        HashMap<String, Integer> attrib = new HashMap<>();
        strength = new JLabel("Strength: " + attrib.get("strength"));
        dexterity = new JLabel("Dexterity: " + attrib.get("dexterity"));
        constitution = new JLabel("Constitution: " + attrib.get("constitution"));
        intelligence = new JLabel("Intelligence: " + attrib.get("intelligence"));
        wisdom = new JLabel("Wisdom: " + attrib.get("wisdom"));
        charisma = new JLabel("Charisma: " + attrib.get("charisma"));
        
        statLayout = new GridLayout(3, 2, 10, 10);
        this.setLayout(statLayout);
        
        this.add(strength);
        this.add(dexterity);
        this.add(constitution);
        this.add(intelligence);
        this.add(wisdom);
        this.add(charisma);
    }



}
