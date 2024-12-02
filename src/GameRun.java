import java.util.Scanner;

public class GameRun {
    public static void Start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = sc.nextLine();

        System.out.println("Choose your job: ");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");

        Job job = new Warrior();
        int jobChoice = sc.nextInt();
        if(jobChoice == 1){
            job = new Warrior();
        }
        else if(jobChoice == 2){
            job = new Mage();
        }
        else{
            System.out.println("Invalid choice");
        }

        RPGCharacter player = new RPGCharacter(name, job, 1);

        System.out.println("Character your job: " + job);

        Monster monster = new Monster("Goblin", 1);

        player.displayStatus();
        monster.displayStatus();

        System.out.println("Battle Start!");

        while(!monster.isDefeated() && player.currentHP() > 0){

            String[] skills = job.getSkills(); // ท่าโจมตีที่มีอยู่ใน array ของแต่ละอาชีพ

            //แสดงท่าโจมตีตามอาชีพ
            System.out.println("Available Skills: ");

            for(int i = 0; i < skills.length; i++){
                System.out.println((i + 1) + ". " + skills[i]);
            }

            System.out.print("Choose a skill to use (1 - " + skills.length + "): ");
            int skillChoice = sc.nextInt() - 1; // -1 เพื่อให้ตรงกับ index ใน array

            if(skillChoice >= 0 && skillChoice < skills.length){
                player.useSkill(monster, skillChoice);
            }
            else{
                System.out.println("Invalid choice");
            }

            monster.attack(player);

            if(player.currentHP() <= 0){
                System.out.println(player.getName() + " has defeated the " + monster.getName() + "!");
                break;
            }

        }

        // ตรวจสอบว่ามอนสเตอร์ตายหรือยัง
        if(monster.isDefeated()){
            System.out.println("You defeated the " + monster.getName() + "!");
            player.levelUp();
            System.out.println("You received the accessory: " );
            if(jobChoice == 1){
                player.equipAccessory(new SwordAccessory());
            }
            if(jobChoice == 2){
                player.equipAccessory(new StaffAccessory());
            }
        }

        player.displayStatus();
        monster.displayStatus();

        sc.close();
    }

}
