import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class Player here.
 * 
 * @author Jay Rixie
 * @version 5/5/16
 */
public class Player
{
    /** description of instance variable x (add comment for each instance variable) */
    private Inventory inv;
    private HashMap<String, Integer> attrib;
    
    private int level;
    private int xp;
    
    private int healthCurr;
    private int healthMax;
    
    private Weapon weap;
    
    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        inv = new Inventory();
        
        attrib = inv.getAttrib();
        
        weap = (Weapon)inv.getItem(0);
        
        
        level = 1;
        xp = 0;
        
        healthCurr = 10;
        healthMax = 10;
    }

   
    public int gainXP(int importXP)
    {
        xp += importXP;
        
        if(xp > 100 && level == 1)
        {
            this.levelUp();
        }
        else if(xp > 300 && level == 2)
        {
            this.levelUp();
        }
        else if(xp > 600 && level == 3)
        {
            this.levelUp();
        }
        else if(xp > 1000 && level == 4)
        {
            this.levelUp();
        }
        else if(xp > 1500 && level == 5)
        {
            this.levelUp();
        }
        else if(xp > 2100 && level == 6)
        {
            this.levelUp();
        }
        
        
        return xp;
    }
    
    public int levelUp()
    {
        level++;
        
        healthMax = level * 10;
        healthCurr = healthCurr + 10 > healthMax ? healthMax : healthCurr + 10;
        
        return level;
    }
    
    public void update()
    {
        weap = (Weapon)inv.getItem(0);
        
        
    }
    
    public Inventory getInv()
    {
        return inv;
    }
}
