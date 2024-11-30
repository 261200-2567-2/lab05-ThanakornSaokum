public interface Job {
    String toString();
    int getMaxHP(int level);
    int getMaxMana(int level);
    double getBaseDamage(int level);
    String[] getSkills();
    int useSkill(int skillIndex, RPGCharacter character);
}

class Warrior implements Job {
    @Override
    public String toString() {
        return "Warrior";
    }

    @Override
    public int getMaxHP(int level) {
        return 150 + (10 * level);
    }

    @Override
    public int getMaxMana(int level) {
        return 50 + (2 * level);
    }

    @Override
    public double getBaseDamage(int level) {
        return 30 * (1 + 0.01 * level) ;
    }

    @Override
    public String[] getSkills() {
        return new String[]{"Punch", "Hook"};
    }

    @Override
    public int useSkill(int skillIndex, RPGCharacter character) {
        int damage = 0;
        switch (skillIndex) {
            case 0:
                damage = (int) (getBaseDamage(1) * 1.2) ;
                System.out.println(character.getName() + " uses Punch!");
                break;
            case 1:
                damage = (int) (getBaseDamage(1) * 1.5) ;
                System.out.println(character.getName() + " uses Hook!");
                break;
            default:
                System.out.println("Invalid skill index");
        }
        return damage;
    }

}

class Mage implements Job {
    @Override
    public String toString() {
        return "Mage";
    }

    @Override
    public int getMaxHP(int level) {
        return 80 + (10 * level);
    }

    @Override
    public int getMaxMana(int level) {
        return 150 + (2 * level);
    }

    @Override
    public double getBaseDamage(int level) {
        return 20 * (1 + 0.05 * level);
    }

    @Override
    public String[] getSkills() {
        return new String[]{"Fireball", "Water Blast"};
    }

    @Override
    public int useSkill(int skillIndex, RPGCharacter character) {
        int damage = 0;
        switch (skillIndex) {
            case 0:
                damage = (int) (getBaseDamage(1) * 1.3);
                System.out.println(character.getName() + " uses Fireball!");
                break;
            case 1:
                damage = (int) (getBaseDamage(1) * 1.6);
                System.out.println(character.getName() + " uses Water Blast!");
                break;
            default:
                System.out.println("Invalid skill index");
        }
        return damage;
    }
}