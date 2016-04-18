import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Used to contain buttons "Spells, Skills, Map, Explore, Rest, Shop" and hand their actions
 * 
 * @author Jay Rixie
 * @version 4/14/16
 */
public class ButtonPanel extends JPanel
{
    /** JButton spellBttn   opens spell information window 
        JButton skillsBttn  opens skills window
        JButton mapBttn     opens map window
        JButton exploreBttn activates explore action
        JButton restBttn    activates rest action
        JButton shopBttn    opens shop window
        GridLayout  bttnLayout  organizes all the buttons*/
    private JButton spellBttn; 
    private JButton skillsBttn;
    private JButton mapBttn;
    private JButton exploreBttn;
    private JButton restBttn;
    private JButton shopBttn;
    private GridLayout bttnLayout;
    /**
     * Default constructor for objects of class ButtonPanel
     */
    public ButtonPanel()
    {
        spellBttn = new JButton("Spells");
        skillsBttn = new JButton("Skills");
        mapBttn = new JButton("Map");
        exploreBttn = new JButton("Explore");
        restBttn = new JButton("Rest");
        shopBttn = new JButton("Shop");
        
        
        bttnLayout = new GridLayout(2, 3, 20, 20);
        this.setLayout(bttnLayout);
        
        this.add(spellBttn);
        this.add(skillsBttn);
        this.add(mapBttn);
        this.add(exploreBttn);
        this.add(restBttn);
        this.add(shopBttn);
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
    public void sampleMethod(int y)
    {

    }

}
