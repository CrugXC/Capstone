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
    private JLabel health;   
    private JLabel level;
    private JLabel xp;
    
    private JLabel strength;
    private JLabel dexterity;
    private JLabel constitution;
    private JLabel intelligence;
    private JLabel wisdom;
    private JLabel charisma;
    
    private Inventory inv;
    
    private GridLayout statLayout;
    /**
     * Default constructor for objects of class PlayerStatsPanel
     */
    public PlayerStatsPanel(Player p)
    {
        inv = p.getTopInv();
        
        health = new JLabel("Health: " + p.getCurrHealth() + "/" + p.getMaxHealth());
        level = new JLabel("Level: " + p.getLevel());
        xp = new JLabel("Experience: " + p.getXP());
        
        HashMap<String, Integer> attrib = inv.getAttrib();
        strength = new JLabel("Strength: " + attrib.get("strength"));
        dexterity = new JLabel("Dexterity: " + attrib.get("dexterity"));
        constitution = new JLabel("Constitution: " + attrib.get("constitution"));
        intelligence = new JLabel("Intelligence: " + attrib.get("intelligence"));
        wisdom = new JLabel("Wisdom: " + attrib.get("wisdom"));
        charisma = new JLabel("Charisma: " + attrib.get("charisma"));
        
        statLayout = new GridLayout(3, 2, 10, 10);
        this.setLayout(statLayout);
        
        
        this.add(health);
        this.add(level);
        
        this.add(strength);
        this.add(dexterity);
        this.add(constitution);
        this.add(intelligence);
        this.add(wisdom);
        this.add(charisma);
    }

    public void update(Player p)
    {
        inv = p.getTopInv();
        
        health = new JLabel("Health: " + p.getCurrHealth() + "/" + p.getMaxHealth());
        level = new JLabel("Level: " + p.getLevel());
        xp = new JLabel("Experience: " + p.getXP());
        
        HashMap<String, Integer> attrib = inv.getAttrib();
        System.out.println(attrib);
        strength = new JLabel("Strength: " + attrib.get("strength"));
        dexterity = new JLabel("Dexterity: " + attrib.get("dexterity"));
        constitution = new JLabel("Constitution: " + attrib.get("constitution"));
        intelligence = new JLabel("Intelligence: " + attrib.get("intelligence"));
        wisdom = new JLabel("Wisdom: " + attrib.get("wisdom"));
        charisma = new JLabel("Charisma: " + attrib.get("charisma"));
    }

}
