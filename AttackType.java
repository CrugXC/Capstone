

/**
 * Write a description of class Attacks here.
 * 
 * @author Jay Rixie
 * @version 5/3/16
 */
public class AttackType
{
    /** description of instance variable x (add comment for each instance variable) */
    private String name;
    private Range damage;
    
    /**
     * Default constructor for objects of class Attacks
     */
    public AttackType(String str, Range rng)
    {
        name = str;
        damage = rng;
    }


    public int attack()
    {
        return damage.roll();
    }
    
    public String getName()
    {
        return name;
    }
}
