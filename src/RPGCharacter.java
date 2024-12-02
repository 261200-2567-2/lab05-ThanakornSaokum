import java.text.DecimalFormat;

public class RPGCharacter {
    private String name;
    private double baseDamage;
    private int maxHP;
    private int maxMana;
    private int level;
    private int currentHP;
    private int currentMana;
    private double baseRunSpeed;
    private double currentRunSpeed;
    private Sword sword;
    private Shield shield;
    private Job job;
    private Accessory accessory;

    public RPGCharacter(String name, Job job, int level) {
        this.name = name;
        this.job = job;
        this.level = level;
        updateStatus();
    }

    public String getName() {
        return name;
    }

    public int currentHP() {
        return currentHP;
    }

    public void levelUp() {
        level++;
        updateStatus();
        System.out.println(name + " leveled up Level " + level + "!");
    }

    public void updateStatus() {
        this.maxHP = job.getMaxHP(level);
        this.currentHP = maxHP;
        this.maxMana = job.getMaxMana(level);
        this.baseDamage = job.getBaseDamage(level);
        this.currentMana = maxMana;
        this.baseRunSpeed = 10.0;
        calculateRunSpeed();
    }

    public void equipAccessory(Accessory accessory) {
        this.accessory = accessory;
        System.out.println(accessory.getName() + "!");
        double increaseDamage = accessory.increaseDamage(this);
        this.baseDamage = job.getBaseDamage(level) + increaseDamage;
    }


//    public void equipSword(Sword sword) {
//        this.sword = sword;
//        calculateRunSpeed();
//    }
//
//    public void equipShield(Shield shield) {
//        this.shield = shield;
//        calculateRunSpeed();
//    }

    public void calculateRunSpeed() {
        currentRunSpeed = baseRunSpeed * (0.01 + 0.5 * level);
        if(sword != null) {
            currentRunSpeed -= sword.calculateSpeedDecrease(baseRunSpeed);
        }
        if(shield != null) {
            currentRunSpeed -= shield.calculateRunSpeedDecrease(baseRunSpeed);
        }
        if(currentRunSpeed < 0){
            currentRunSpeed = 0;
        }
    }

    //method for decrease when monster attack
    public void takeDamage(int damage) {
        currentHP -= damage;
        if(currentHP <= 0) {
            currentHP = 0;
        }
        System.out.println(this.name + " took " + damage + " damage! Remaining HP: " + currentHP);
    }

//    public void performAttack() {
//        job.performAttack(this);
//    }

    //method for useSkill in main
    public void useSkill(Monster monster, int skillIndex) {
        // ใช้โจมตีตามสกิลที่เลือก
        int damage = job.useSkill(skillIndex, this);

        // ทำดาเมจกับมอนสเตอร์
        monster.takeDamage(damage);
    }

    public void displayStatus() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("=========================================");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Damage: " + baseDamage);
        //System.out.println("Job: " + job);
        System.out.println("HP: " + currentHP + "/" + maxHP);
        System.out.println("Mana: " + currentMana + "/" + maxMana);
        System.out.println("Run Speed: " + df.format(currentRunSpeed));
        //System.out.println("Sword: " + (sword != null ? sword : "None"));
        //System.out.println("Shield: " + (shield != null ? shield : "None"));
        System.out.println("=========================================");
    }

}
