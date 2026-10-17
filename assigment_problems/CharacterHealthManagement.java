class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        int newHealth = health - amount;
        if (newHealth < 0) {
            newHealth = 0;
        }
        health = newHealth;
    }

    public void heal(int amount) {
        int newHealth = health + amount;
        if (newHealth > maxHealth) {
            newHealth = maxHealth;
        }
        health = newHealth;
    }

    public int getHealth() {
        return health;
    }
}

public class CharacterHealthManagement {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}
