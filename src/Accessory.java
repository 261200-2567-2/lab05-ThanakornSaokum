public interface Accessory {
    String getName();
    int increaseDamage(RPGCharacter character);
    String getSpecialSkill(); // สกิลพิเศษจากอุปกรณ์
    int getManaCost(); // ค่ามานาที่ต้องใช้ในการร่ายสกิล
}

class SwordAccessory implements Accessory {
    @Override
    public String getName() {
        return "Flame Sword";
    }

    @Override
    public int increaseDamage(RPGCharacter character) {
        // เพิ่มดาเมจให้ตัวละคร
        int damage = 10;
        return damage;
    }

    @Override
    public String getSpecialSkill() {
        return "Flame Slash";  // เพิ่มสกิลใหม่
    }

    @Override
    public int getManaCost() {
        return 20; // ต้องการมานาเท่านี้ในการใช้สกิล
    }
}

class StaffAccessory implements Accessory {
    @Override
    public String getName() {
        return "Arcane Staff";
    }

    @Override
    public int increaseDamage(RPGCharacter character) {
        // เพิ่มดาเมจให้ตัวละคร
        int damage = 15;
        return damage;
    }

    @Override
    public String getSpecialSkill() {
        return "Arcane Blast"; // สกิลโจมตีพิเศษ
    }

    @Override
    public int getManaCost() {
        return 30; // ค่ามานาในการใช้สกิลนี้
    }
}