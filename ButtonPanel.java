import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

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
    
    private MonsterPanel m;
    /**
     * Default constructor for objects of class ButtonPanel
     */
    public ButtonPanel(MonsterPanel m1)
    {
        ActionListener listener = new ClickListener();
        spellBttn = new JButton("Spells");
        spellBttn.addActionListener(listener);
        skillsBttn = new JButton("Skills");
        skillsBttn.addActionListener(listener);
        mapBttn = new JButton("Map");
        mapBttn.addActionListener(listener);
        exploreBttn = new JButton("Explore");
        exploreBttn.addActionListener(listener);
        restBttn = new JButton("Rest");
        restBttn.addActionListener(listener);
        shopBttn = new JButton("Shop");
        shopBttn.addActionListener(listener);
        
        
        m = m1;
        
        
        bttnLayout = new GridLayout(2, 3, 20, 20);
        this.setLayout(bttnLayout);
        
        this.add(spellBttn);
        this.add(skillsBttn);
        this.add(mapBttn);
        this.add(exploreBttn);
        this.add(restBttn);
        this.add(shopBttn);
    }

    public class ClickListener implements ActionListener
    {
        public ClickListener()
        { 
        }
        
        public void actionPerformed(ActionEvent event)
        {
            //Determines which button was clicked and runs block
            if (event.getActionCommand().equals("Explore"))
            {
                m.addMonster(Generator.generateMonster());
                System.out.println("test");
            }
            
            
            else
            {
                //Double checking error
                System.out.println("error");
            }
        }
    }

}
