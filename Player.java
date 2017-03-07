import java.util.ArrayList;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;
/**
 * Write a description of class Player here.
 * 
 * @author Jay Rixie
 * @version 5/5/16
 */
public class Player
{
    /** description of instance variable x (add comment for each instance variable) */
    private Inventory mainInv;
    private Inventory topInv;
    private HashMap<String, Integer> attrib;
    
    private int level;
    private int xp;
    
    private int healthCurr;
    private int healthMax;
    
    private Random r1;
    
    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        mainInv = new Inventory(8, 5);
        topInv = new Inventory(1, 2);
        
        r1 = new Random();
        
        BufferedImage weaponImg = null;
        try {
            weaponImg = ImageIO.read(new File("LongSword.png"));
        } catch (IOException e){}
        
        topInv.addItem(new Weapon(new AttackType("Slash", new Range(1,3)), "Basic Wooden Sword", Generator.hashMapInitializer(1,1,1,1,1,1), weaponImg), 0);
        
        BufferedImage armorImg = null;
        try {
            armorImg = ImageIO.read(new File("LeatherArmor.gif"));
        } catch (IOException e){}
        topInv.addItem(new Armor(5, "Basic Leather Armor", Generator.hashMapInitializer(1,1,1,1,1,1), armorImg), 1);
        
        attrib = topInv.getAttrib();
        
        
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
    
    public void attack(MonsterSprite m)
    {
        if(topInv.getItem(0) != null)
        {
            int roll = r1.nextInt(21) + 1;
            int damage = topInv.getItem(0).attack();
            
            if(roll == 1)
            {
                InformationPanel.update("\nCritical Failure!");
            }
            else if(roll == 20)
            {
                InformationPanel.update("\nNatural 20!");
                m.takeDamage(damage);
                InformationPanel.update("\nYou attack for " + damage + " damage!");
            }
            else
            {
                roll += attrib.get("strength");
                if(m.getAttacked(roll, damage))
                {
                    m.takeDamage(damage);
                    InformationPanel.update("\nYou attack for " + damage + " damage!");
                }
                else
                {
                    InformationPanel.update("\nYou miss!");
                }
            }
            
        }
        else
        {
            InformationPanel.update("\nYou have no weapon!");
        }
    }
        
    public boolean takeDamage(int damage)
    {
        healthCurr -= damage;
        return healthCurr <= 0;
    }
    
    public boolean getAttacked(int roll, int damage)
    {
        InformationPanel.update("\nThey roll a " + roll + "!");
        return(roll >= this.getAC());
    }
    
    public boolean dead()
    {
        return healthCurr <= 0;
    }
    
    public Inventory getMainInv()
    {
        return mainInv;
    }
    
    public Inventory getTopInv()
    {
        return topInv;
    }
    
    public int getAC()
    {
        if (topInv.getItem(1) instanceof Armor)
        {
            Armor armor = (Armor) topInv.getItem(1);
            return armor.getAC();
        }
        else
        {
            return 0;
        }
    }
    
    public int getMaxHealth()
    {
        return healthMax;
    }
    
    public int getCurrHealth()
    {
        return healthCurr;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public int getXP()
    {
        return xp;
    }
    
    public HashMap<String, Integer> getAttrib()
    {
        return attrib;
    }
    
    public void rest()
    {
        healthCurr = healthMax;
    }
}
