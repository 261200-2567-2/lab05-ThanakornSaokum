import java.text.DecimalFormat;

public class Shield {
    private double baseDefense;
    private int level;

    public Shield(double baseDefense, int level) {
        this.baseDefense = baseDefense;
        this.level = level;
    }

    public double calculateDefense() {
        return baseDefense * (1 + 0.05 * level);
    }

    public double calculateRunSpeedDecrease(double baseRunSpeed) {
        return baseRunSpeed * (0.1 + 0.08 * level);
    }

    public void levelUp(){
        level++;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Shield (Level " + level + ", Defense: " + df.format(calculateDefense()) + ")";
    }
}
