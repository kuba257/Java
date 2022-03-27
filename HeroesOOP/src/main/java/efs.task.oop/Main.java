package efs.task.oop;

public class Main {
    public static void main(String[] args) {
        Villager[] villagers = {
            new Villager("Kashya",30),
            new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER),
            new Villager("Gheed", 50),
            new ExtraordinaryVillager("Deckard Cain",85, ExtraordinaryVillager.Skill.IDENTIFY),
            new Villager("Warriv", 35),
            new Villager("Flawia", 25)
        };
        for(Villager villager : villagers) {
            villager.sayHello();
        }
        Object objectAkara = villagers[1];
        Object objectDeckardCain = villagers[3];
        boolean bsmhIsDead = false;
        boolean andIsDead = false;
        Villager presentVillager = villagers[0];

        System.out.println("\nEPICKA WALKA: ");
        while(Monsters.monstersHealth > 0) {
            System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
            for(int i=0; i<villagers.length; i++) {
                if (villagers[i].getHealth() > 0) {
                    presentVillager = villagers[i];
                    break;
                }
            }
            System.out.println("Aktualnie walczacy osadnik to " + presentVillager.getName());
            if(Monsters.andariel.getHealth() > 0) {
                presentVillager.attack(Monsters.andariel);
                Monsters.andariel.attack(presentVillager);
            }
            if(Monsters.andariel.getHealth() <= 0 && !andIsDead) {
                System.out.println("Potwór andariel poległ w walce.");
                Monsters.monstersHealth -= Monsters.andariel.getHealth();
                andIsDead = true;
            }
            if(presentVillager.getHealth() > 0 && Monsters.blacksmith.getHealth() > 0) {
                presentVillager.attack(Monsters.blacksmith);
                Monsters.blacksmith.attack(presentVillager);
            }
            if(presentVillager.getHealth() <= 0)
                System.out.println("Mieszkaniec wioski " + presentVillager.getName() + " poległ w walce.");
            if(Monsters.blacksmith.getHealth() <= 0 && !bsmhIsDead) {
                System.out.println("Potwór blacksmith poległ w walce.");
                bsmhIsDead = true;
            }
        }
        System.out.println("Obozowisko ocalone!");
        villagers[1] = (ExtraordinaryVillager) objectAkara;
        villagers[3] = (ExtraordinaryVillager) objectDeckardCain;
    }
}
