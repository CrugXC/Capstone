import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Write a description of class MonsterDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterDisplay extends JPanel
{
    private MonsterSprite m;
    
    public MonsterDisplay()
    {
        m = null;
    }
    
    public MonsterDisplay(MonsterSprite m1)
    {
        m = m1;
    }
    
    public void addMonster(MonsterSprite m1)
    {
        m = m1;
    }
    
    public MonsterSprite getMonster()
    {
        return m;
    }
    
    public void deleteMonster()
    {
        m = null;
    }
    
    public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            System.out.println("test2");
            if(m != null)
            {
                Generator.crop(m.getImage(), new Rectangle(100, 100));
                m.draw((Graphics2D)g, 100, 100);
                System.out.println("test3");
            }
            
        }
}
