import java.text.DecimalFormat;

public class Sword {
    private double baseDamage;
    private int level;

    public Sword(double baseDamage, int level) {
        this.baseDamage = baseDamage;
        this.level = level;
    }

    public double calculateDamage() {
        return baseDamage *(1 + 0.1 * level);
    }

    public double calculateSpeedDecrease(double baseRunSpeed) {
        return baseRunSpeed *(0.01 + 0.04 * level);
    }

    public void levelUp(){
        level++;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "Sword (Level " + level + "), Damage: " + df.format(calculateDamage()) + ")";
    }
}
