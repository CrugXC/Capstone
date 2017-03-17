import java.util.HashMap;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterSprite extends Sprite
{
    /** description of instance variable x (add comment for each instance variable) */
    private String name;
    
    //healthMax, healthCurr, str, dex, con, intel, wis, cha
    private HashMap<String, Integer> info;
    private HashMap<Integer, AttackType> attacks;
    
    private Random r1;
    
    private int healthCurr;
    private int healthMax;
    
    private int ac;
    
    
    /**
     * Default constructor for objects of class Monster
     */
    public MonsterSprite(BufferedImage img, String importName, HashMap<String, Integer> stats, HashMap<Integer, AttackType> importAttacks)
    {
        super(img);
        name = importName;
        info = stats;
        attacks = importAttacks;
        
        healthMax = 1 + info.get("constitution");
        healthCurr = healthMax;
        
        ac = 10;
        
        r1 = new Random();
    }
    
    public int getHealthCurr()
    {
        return healthCurr;
    }
    
    public int getHealthMax()
    {
        return healthMax;
    }
    
    public boolean takeDamage(int damage)
    {
        healthCurr -= damage;
        info.put("healthCurr", healthCurr);
        System.out.println(healthCurr <= 0?"Monster Dead":"Monster Alive");
        return healthCurr <= 0;
    }
    
    public boolean dead()
    {
        return healthCurr <= 0;
    }
    
    public void attack(Player p)
    {
        int roll = r1.nextInt(21) + 1;
        AttackType att = attacks.get(r1.nextInt(attacks.size()));
        int damage = att.attack();
        
        if(roll == 1)
            {
                InformationPanel.update("\n\nThey roll a 1!");
                InformationPanel.update("\nCritical Failure!");
            }
            else if(roll == 20)
            {
                InformationPanel.update("\n\nThey roll a Natural 20!");
                p.takeDamage(damage*2);
                InformationPanel.update("\n" + name + " attacked you with " + att + " for " + (damage*2) + " damage!");
            }
            else
            {
                roll += info.get("strength");
                if(p.getAttacked(roll, damage))
                {
                    p.takeDamage(damage);
                    InformationPanel.update("\n" + name + " attacked you with " + att + " for " + damage + " damage!");
                }
                else
                {
                    InformationPanel.update("\nThey miss!");
                }
            }
    }
    
    public boolean getAttacked(int roll, int damage)
    {
        InformationPanel.update("\n\nYou roll a " + roll + "!");
        return(roll >= ac);
    }
    
    public HashMap<String, Integer> getAttrib()
    {
        return info;
    }
}
