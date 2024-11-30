public class Monster {
    private String name;
    private int level;
    private int maxHP;
    private int currentHP;
    private int attackPower;

    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
        this.maxHP = 50 + (level * 10);
        this.currentHP = maxHP;
        this.attackPower = 10 + (level * 5);
    }

    public String getName() {
        return name;
    }

    //method for attack character เอาไว้ตีตัวละคร
    public void attack(RPGCharacter character) {
        int damage = this.attackPower;
        character.takeDamage(damage);
        System.out.println(this.name + " attacks " + character.getName() + " for " + damage + " damage!");
    }

    public void displayStatus(){
        System.out.println("=========================================");
        System.out.println("Monster: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + currentHP + "/" + maxHP);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("=========================================");
    }

    //method for decrease hp when character attack
    public void takeDamage(int damage) {
        currentHP -= damage;
        if (currentHP <= 0) {
            currentHP = 0;
        }
        System.out.println(this.name + " took " + damage + " damage! Remaining HP: " + currentHP);
    }

    // check monster dead?
    public boolean isDefeated(){
        return currentHP <= 0;
    }
}
