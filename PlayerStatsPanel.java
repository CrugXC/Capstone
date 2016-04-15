import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

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
        strength = new JLabel("Strength: " + inv.getStrength);
        dexterity = new JLabel("Dexterity: " + inv.getDexterity);
        constitution = new JLabel("Constitution: " + inv.getConstitution);
        intelligence = new JLabel("Intelligence: " + inv.getIntelligence);
        wisdom = new JLabel("Wisdom: " + inv.getWisdom);
        charisma = new JLabel("Charisma: " + inv.getCharisma);
        
        statLayout = new GridLayout(3, 2, 10, 10);
        this.setLayout(statLayout);
        
        this.add(strength);
        this.add(dexterity);
        this.add(constitution);
        this.add(intelligence);
        this.add(wisdom);
        this.add(charisma);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x+y;
    }

}
