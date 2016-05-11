import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class MonsterPanel here.
 * 
 * @author Jay Rixie 
 * @version 4/15/16
 */
public class MonsterPanel extends JPanel
{
    /** JPanel monsterScreen        Monster sprite will appear here
     *  JPanel actionButtons        Used to layout buttons properly
        JButton action1             Link up to action1
        JButton action2             Link up to action2
        JButton action3             Link up to action3
        JButton action4             Link up to action4*/
        
    private JPanel monsterScreen;
    private JPanel monsterInfo;
    private JPanel actionButtons;
    private JButton action1;
    private JButton action2;
    private JButton action3;
    private JButton action4;
    
    private Combat combat;
    
    private Player p;
    private MonsterSprite m;
    /**
     * Constructor for objects of class MonsterPanel
     */
    public MonsterPanel(Player p1)
    {
        monsterScreen = new JPanel();
        monsterScreen.setPreferredSize(new Dimension(300, 300));
        monsterScreen.setBackground(Color.WHITE);
        
        monsterInfo = new JPanel();
        
        
        actionButtons = new JPanel();
        
        ActionListener listener = new ClickListener();
        
        action1 = new JButton("Attack");
        action1.addActionListener(listener);
        action2 = new JButton("Defend");
        action2.addActionListener(listener);
        action3 = new JButton("Items");
        action3.addActionListener(listener);
        action4 = new JButton("Run");
        action4.addActionListener(listener);
        
        actionButtons.setLayout(new GridLayout(2, 2));
        actionButtons.add(action1);
        actionButtons.add(action2);
        actionButtons.add(action3);
        actionButtons.add(action4);
        
        this.setLayout(new BorderLayout());
        this.add(monsterInfo, BorderLayout.NORTH);
        this.add(monsterScreen, BorderLayout.CENTER);
        this.add(actionButtons, BorderLayout.SOUTH);
        
        p = p1;
        m = null;
        
        combat= new Combat(p, this);
    }

    public class ClickListener implements ActionListener
    {
        public ClickListener()
        { 
        }
        
        public void actionPerformed(ActionEvent event)
        {
            //Determines which button was clicked and runs block
            if (event.getActionCommand().equals("Attack"))
            {
                if(combat.isCombat())
                {
                    combat.attack();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                    "Combat is not active.");
                }
            }
            
            else if (event.getActionCommand().equals("Defend"))
            {
                JOptionPane.showMessageDialog(null,
                "Future Implementation Required");
                
            }
            
            else if (event.getActionCommand().equals("Items"))
            {
                
                JOptionPane.showMessageDialog(null,
                "Future Implementation Required");
                
            }
            
            else if (event.getActionCommand().equals("Run"))
            {
                if(combat.isCombat())
                {
                    combat.run();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                    "Combat is not active.");
                }
            }
            
            else
            {
                //Double checking error
                System.out.println("error");
            }
        }
    }
    
    
        public void addMonster(MonsterSprite m1)
        {
            m = m1;
            combat.startCombat(m1);
            repaint();
        }
        
        public void deleteMonster()
        {
            m = null;
            
            repaint();
        }
        
        public void paintComponent(Graphics g)
        {
            System.out.println("test2");
            if(m != null)
            {
                m.draw((Graphics2D)g, 20, 20);
            }
        }
}
