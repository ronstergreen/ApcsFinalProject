
public class Monster
{
    private int dmg;

    private int health;

    private int cooldown;
    private int maxHealth;

    /**
     * @param d dmg
     * @param h health
     * @param c cooldown
     */
    public Monster(int d, int h, int c) {
        dmg = d;
        health = h;
        cooldown = c;
        maxHealth = health;
    }
    
    public Monster() {
        dmg = 5;
        health = 50;
        cooldown = 750;
        maxHealth = health;
    }
    /**
     * @return damge
     */
    public int getDamage()
    {
        return dmg;
    }
    
    /**
     * @return health remaining
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * @return Cooldown for attack
     */
    public int getCool()
    {
        return cooldown;
    }
    
    public int lowerHealth(int d) {
        health -= d;
        return health;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }

}