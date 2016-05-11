import java.util.HashMap;
import java.util.Random;
import java.awt.Image;
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
    
    /**
     * Default constructor for objects of class Monster
     */
    public MonsterSprite(Image img, String importName, HashMap<String, Integer> stats, HashMap<Integer, AttackType> importAttacks)
    {
        super(img);
        name = importName;
        info = stats;
        attacks = importAttacks;
        
        r1 = new Random();
    }
    
    public boolean takeDamage(int damage)
    {
        int healthCurr = info.get("healthCurr");
        healthCurr -= damage;
        info.put("healthCurr", healthCurr);
        return healthCurr <= 0;
    }
    
    public boolean dead()
    {
        int healthCurr = info.get("healthCurr");
        return healthCurr <= 0;
    }
    
    public void attack(Player p)
    {
        p.takeDamage(attacks.get(r1.nextInt(info.size())).attack());
    }
    
    public HashMap<String, Integer> getAttrib()
    {
        return info;
    }
}
