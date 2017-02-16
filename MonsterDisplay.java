import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Write a description of class MonsterDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterDisplay extends JPanel
{
    private MonsterSprite m;
    
    private Rectangle2D.Double healthBar;
    private Rectangle2D.Double healthBarBack;
    
    public MonsterDisplay()
    {
        m = null;
        
        healthBarBack = new Rectangle2D.Double(0, 0, 0, 0);
        healthBar = new Rectangle2D.Double(1, 1, 0, 0);
    }
    
    public MonsterDisplay(MonsterSprite m1)
    {
        m = m1;
    }
    
    public void addMonster(MonsterSprite m1)
    {
        m = m1;
        healthBar.setRect(1, 1, 100, 20);
        healthBarBack.setRect(0, 0, 102, 22);
    }
    
    public MonsterSprite getMonster()
    {
        return m;
    }
    
    public void deleteMonster()
    {
        m = null;
    }
    
    public void update()
    {
        if(m!=null)
        {
            healthBar.setRect(1, 1, (int)(((double)m.getHealthCurr()/ (double)m.getHealthMax()) * 100), 20);
            System.out.println(m.getHealthCurr());
            System.out.println(m.getHealthMax());
            System.out.println((m.getHealthCurr()/ m.getHealthMax()) * 100);
            System.out.println(m.getHealthCurr());
        }
        else
        {
            healthBar.setRect(1,1, 0, 0);
        }
        
        repaint();
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
                
                Graphics2D g2 = (Graphics2D) g;
                
                g2.draw(healthBarBack);
                g2.setColor(Color.BLACK);
                g2.fill(healthBarBack);
                
                g2.draw(healthBar);
                g2.setColor(Color.GREEN);
                g2.fill(healthBar);
            }
            
        }
}
