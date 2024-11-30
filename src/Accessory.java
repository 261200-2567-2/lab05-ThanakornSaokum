public interface Accessory {
    String getName();
    void applyEffect(RPGCharacter character);
    String getSpecialSkill(); // สกิลพิเศษจากอุปกรณ์
    int getManaCost(); // ค่ามานาที่ต้องใช้ในการร่ายสกิล
}

class SwordAccessory implements Accessory {
    @Override
    public String getName() {
        return "Flame Sword";
    }

    @Override
    public void applyEffect(RPGCharacter character) {
        System.out.println("Flame Sword equipped! Base damage increased.");
        // เพิ่มดาเมจให้ตัวละคร

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
    public void applyEffect(RPGCharacter character) {
        System.out.println("Arcane Staff equipped! Magic attack increased.");
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