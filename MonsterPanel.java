import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
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

    /**
     * Constructor for objects of class MonsterPanel
     */
    public MonsterPanel()
    {
        monsterScreen = new JPanel();
        monsterScreen.setPreferredSize(new Dimension(300, 300));
        monsterScreen.setBackground(Color.WHITE);
        
        actionButtons = new JPanel();
        
        action1 = new JButton("Attack");
        action2 = new JButton("Defend");
        action3 = new JButton("Items");
        action4 = new JButton("Run");
        
        actionButtons.setLayout(new GridLayout(2, 2));
        actionButtons.add(action1);
        actionButtons.add(action2);
        actionButtons.add(action3);
        actionButtons.add(action4);
        
        this.setLayout(new BorderLayout());
        this.add(monsterScreen, BorderLayout.CENTER);
        this.add(actionButtons, BorderLayout.SOUTH);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod(int y)
    {

    }
}
